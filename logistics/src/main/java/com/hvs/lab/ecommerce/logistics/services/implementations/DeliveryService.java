package com.hvs.lab.ecommerce.logistics.services.implementations;

import com.hvs.lab.ecommerce.logistics.services.contracts.IDeliveryService;
import com.hvs.lab.shared.models.Delivery;
import com.hvs.lab.shared.models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class DeliveryService implements IDeliveryService {

    private final RestTemplate restTemplate;

    private final NotificationHandlerService notificationHandlerService;
    @Value("${persistence-delivery-url}")
    private String deliveryUrl;

    @Value("${persistence-order-url}")
    private String orderUrl;

    public DeliveryService(NotificationHandlerService notificationHandlerService) {
        this.restTemplate = new RestTemplateBuilder()
                .setReadTimeout(Duration.ofMillis(1200))
                .setConnectTimeout(Duration.ofMillis(1000))
                .build();
        this.notificationHandlerService = notificationHandlerService;


    }

    @Override
    public Delivery findDelivery(long deliveryId, boolean timeout, boolean retires) throws IOException, TimeoutException {
        var delivery = this.restTemplate.getForObject(deliveryUrl.concat(String.valueOf(deliveryId)), Delivery.class);
        if (delivery != null) {
            try {
                delivery = sendRequest(delivery, timeout);
            } catch(ResourceAccessException ex) {
                try {
                    log.warn("timeout thrown");
                    log.info("retrying find order");
                    if (!retires) {
                        timeout = false;
                    }
                    delivery = sendRequest(delivery, timeout);
                } catch(ResourceAccessException e) {
                    notificationHandlerService.sendNotification(String.format("Find Order Timeout, order nro: %s", delivery.getOrderId()));
                    throw new TimeoutException("Timeout finding order");
                }
            }
        } else {
            log.error("Delivery Null");
        }
        return delivery;
    }

    public Delivery sendRequest(Delivery delivery, boolean timeout) throws ResourceAccessException{
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-TIMEOUT", String.valueOf(timeout));

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Order> response = restTemplate.exchange(
                orderUrl.concat(String.valueOf(delivery.getOrderId())), HttpMethod.GET, requestEntity, Order.class);
        var order = response.getBody();

        if (order != null) {
            log.info("order found, id: {}", order.getId());
            delivery.setOrderStatus(order.getStatus());
        } else {
            log.error("Order Null");
        }


        return delivery;

    }
}
