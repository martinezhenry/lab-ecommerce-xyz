package com.hvs.lab.ecommerce.persistence.services.contracts;

import com.hvs.lab.shared.models.Delivery;

public interface IDeliveryService {
    Delivery findDelivery(long deliveryId);
    Delivery save(Delivery delivery);
}
