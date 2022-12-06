package com.hvs.lab.sales.components.aspects;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configuration {
    @Bean
    Queue queueCreated() {
        return new Queue("order.created", false);
    }

    @Bean
    Queue queueValidation() {
        return new Queue("order.inventory.validation", false);
    }

    @Bean
    Queue queueRequest() {
        return new Queue("order.payment.request", false);
    }
}
