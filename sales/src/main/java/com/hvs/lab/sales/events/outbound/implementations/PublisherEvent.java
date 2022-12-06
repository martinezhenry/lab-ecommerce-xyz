package com.hvs.lab.sales.events.outbound.implementations;

import com.hvs.lab.sales.events.outbound.contracts.IPublisherEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PublisherEvent implements IPublisherEvent {

    private final RabbitTemplate rabbitTemplate;

    public PublisherEvent(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishEvent(String queue, Object event) {
        log.info("publish event to queue: {}", queue);
        this.rabbitTemplate.convertAndSend(queue, event);
    }
}
