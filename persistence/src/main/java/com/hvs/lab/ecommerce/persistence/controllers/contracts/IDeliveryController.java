package com.hvs.lab.ecommerce.persistence.controllers.contracts;

import com.hvs.lab.shared.models.Delivery;

public interface IDeliveryController {
    Delivery findDelivery(long deliveryId);

    Delivery save(Delivery delivery);

}
