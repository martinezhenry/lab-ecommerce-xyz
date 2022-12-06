package com.hvs.lab.ecommerce.persistence.controllers.implementations;

import com.hvs.lab.ecommerce.persistence.controllers.contracts.IDeliveryController;
import com.hvs.lab.ecommerce.persistence.services.contracts.IDeliveryService;
import com.hvs.lab.shared.models.Delivery;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("delivery")
public class DeliveryController implements IDeliveryController {

    private IDeliveryService deliveryService;

    public DeliveryController(IDeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    @GetMapping("/{deliveryId}")
    public Delivery findDelivery(@PathVariable long deliveryId) {
        return deliveryService.findDelivery(deliveryId);
    }

    @Override
    @PostMapping
    public Delivery save(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }


}
