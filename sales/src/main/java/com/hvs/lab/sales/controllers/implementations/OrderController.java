package com.hvs.lab.sales.controllers.implementations;

import com.hvs.lab.sales.components.aspects.annotations.TimeTakenLogger;
import com.hvs.lab.sales.controllers.contracts.IOrderController;
import com.hvs.lab.sales.services.contracts.IOrderService;
import com.hvs.lab.shared.models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hvs.lab.shared.components.constants.Sales.ORDER_PATH;

@RestController
@RequestMapping(ORDER_PATH)
@Slf4j
public class OrderController implements IOrderController {

    private IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @TimeTakenLogger
    public Order registerOrder(@RequestBody Order order) {
        log.info("registering order...");
        Order rsp = orderService.saveOrder(order);
        return rsp;

    }
}
