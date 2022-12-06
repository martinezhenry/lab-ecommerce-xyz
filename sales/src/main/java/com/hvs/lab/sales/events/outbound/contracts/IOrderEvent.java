package com.hvs.lab.sales.events.outbound.contracts;

import com.hvs.lab.shared.models.Order;

public interface IOrderEvent {
    Order publishOrderEvents(Order order);
}
