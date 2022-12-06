package com.hvs.lab.sales.events.outbound.implementations;

import com.hvs.lab.sales.events.outbound.contracts.IOrderEvent;
import com.hvs.lab.sales.events.outbound.contracts.IPublisherEvent;
import com.hvs.lab.shared.models.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderEvent implements IOrderEvent {

    private IPublisherEvent publisherEvent;


    public OrderEvent(IPublisherEvent publisherEvent) {
        this.publisherEvent = publisherEvent;
    }

    @Override
    public Order publishOrderEvents(Order order) {
        this.publisherEvent.publishEvent("order.created", order);
        this.publisherEvent.publishEvent("order.inventory.validation", order);
        this.publisherEvent.publishEvent("order.payment.request", order);
        return order;
    }


}
