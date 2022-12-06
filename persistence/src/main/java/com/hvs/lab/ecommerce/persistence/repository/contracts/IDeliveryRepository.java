package com.hvs.lab.ecommerce.persistence.repository.contracts;

import com.hvs.lab.ecommerce.persistence.entities.DeliveryEntity;
import org.springframework.data.repository.CrudRepository;

public interface IDeliveryRepository extends CrudRepository<DeliveryEntity, Long> {
}
