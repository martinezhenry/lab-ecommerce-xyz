package com.hvs.lab.sales.controllers.implementations;

import com.hvs.lab.sales.controllers.contracts.ISalesController;
import com.hvs.lab.shared.models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hvs.lab.shared.components.constants.Sales.REGISTER_ORDER_PATH;
import static com.hvs.lab.shared.components.constants.Sales.SALES_PATH;

@RestController
@RequestMapping(SALES_PATH)
@Slf4j
public class SalesController implements ISalesController {
    @Override
    @PostMapping(REGISTER_ORDER_PATH)
    public void registerOrder(Order order) {
      log.info("registering order...");

    }
}
