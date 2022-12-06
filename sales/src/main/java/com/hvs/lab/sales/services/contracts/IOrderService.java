package com.hvs.lab.sales.services.contracts;

import com.hvs.lab.shared.models.Order;

public interface IOrderService {
    Order saveOrder(Order order);
    Order findOrder(long orderId);
}
