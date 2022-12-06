package com.hvs.lab.ecommerce.persistence.repository.contracts;

import com.hvs.lab.ecommerce.persistence.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository extends CrudRepository<OrderEntity, Long> {
}
