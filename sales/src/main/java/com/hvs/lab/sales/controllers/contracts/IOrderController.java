package com.hvs.lab.sales.controllers.contracts;

import com.hvs.lab.shared.models.Order;

public interface IOrderController {
    Order registerOrder(Order order);
}
