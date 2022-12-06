package com.hvs.lab.ecommerce.persistence.services.contracts;

import com.hvs.lab.shared.models.Order;

public interface IOrderService {
    Order saveOrder(Order order);

    Order calculateTotal(Order order);

    Order findOrder(long orderId);
}
