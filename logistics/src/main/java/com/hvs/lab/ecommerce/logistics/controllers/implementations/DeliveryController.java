package com.hvs.lab.ecommerce.logistics.controllers.implementations;

import com.hvs.lab.ecommerce.logistics.controllers.contracts.IDeliveryController;
import com.hvs.lab.ecommerce.logistics.services.contracts.IDeliveryService;
import com.hvs.lab.shared.models.Delivery;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("delivery")
public class DeliveryController implements IDeliveryController {

    private final IDeliveryService deliveryService;

    public DeliveryController(IDeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @Override
    @GetMapping("{deliveryId}")
    public Delivery getDelivery(@PathVariable long deliveryId,
                                @RequestHeader(name = "X-TIMEOUT", required = false, defaultValue = "false") boolean timeout,
                                @RequestHeader(name = "X-TIMEOUT-RETRIES", required = false, defaultValue = "true") boolean retries) throws IOException, TimeoutException {
        return deliveryService.findDelivery(deliveryId, timeout, retries);
    }
}
