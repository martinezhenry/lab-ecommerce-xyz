package com.hvs.lab.sales.services.implementations;

import com.hvs.lab.sales.events.outbound.contracts.IOrderEvent;
import com.hvs.lab.sales.services.contracts.IOrderService;
import com.hvs.lab.shared.models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.hvs.lab.shared.components.constants.Sales.ORDER_PATH;
import static com.hvs.lab.shared.components.constants.Sales.PERSISTENCE_BASE_URL;

@Service
@Slf4j
public class OrderServices implements IOrderService {

    private RestTemplate restTemplate;
    private final IOrderEvent orderEvent;

    @Value("${persistence-order-url}")
    private String persistenceOrderUrl;


    public OrderServices(IOrderEvent orderEvent) {
        /*this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8081/persistence")
                .build();*/

        this.restTemplate = new RestTemplate();
        this.orderEvent = orderEvent;
    }

    @Override
    public Order saveOrder(Order order) {
        log.info("saving order");

        Order rsp = this.restTemplate.postForObject(persistenceOrderUrl, order, Order.class);
        this.orderEvent.publishOrderEvents(rsp);

        return rsp;


    }

    @Override
    public Order findOrder(long orderId) {
        Order rsp = this.restTemplate.getForObject(persistenceOrderUrl.concat(String.valueOf(orderId)), Order.class);
        return rsp;
    }
}
