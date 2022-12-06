package com.hvs.lab.ecommerce.logistics.controllers.contracts;

import com.hvs.lab.shared.models.Delivery;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface IDeliveryController {
    Delivery getDelivery(long deliveryId, boolean timeout, boolean retries) throws IOException, TimeoutException;
}
