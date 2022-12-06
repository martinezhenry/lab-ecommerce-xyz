package com.hvs.lab.sales.events.outbound.contracts;

public interface IPublisherEvent {

    void publishEvent(String queue, Object event);
}
