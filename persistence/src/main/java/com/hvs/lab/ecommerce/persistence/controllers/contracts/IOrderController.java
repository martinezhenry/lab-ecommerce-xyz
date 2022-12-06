package com.hvs.lab.ecommerce.persistence.controllers.contracts;

import com.hvs.lab.shared.models.Order;

public interface IOrderController {
    Order saveOrder(Order order);
    Order findOrder(long orderId, boolean timeout) throws InterruptedException;
}
