package com.hvs.lab.ecommerce.persistence.controllers.implementations;

import com.hvs.lab.ecommerce.persistence.controllers.contracts.IOrderController;
import com.hvs.lab.ecommerce.persistence.services.contracts.IOrderService;
import com.hvs.lab.shared.models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.hvs.lab.shared.components.constants.Sales.ORDER_PATH;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController implements IOrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        log.info("saving order: {}", order);

            return this.orderService.saveOrder(order);

    }

    @Override
    @GetMapping("{orderId}")
    public Order findOrder(@PathVariable long orderId, @RequestHeader("X-TIMEOUT") boolean timeout) throws InterruptedException {
        if (timeout) {
            Thread.sleep(1500);
        } else {
            return orderService.findOrder(orderId);
        }

        return null;
    }
}
