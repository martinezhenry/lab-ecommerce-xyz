package com.hvs.lab.ecommerce.logistics.services.contracts;

import com.hvs.lab.shared.models.Delivery;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface IDeliveryService {

    Delivery findDelivery(long deliveryId, boolean timeout, boolean retries) throws IOException, TimeoutException;

}
