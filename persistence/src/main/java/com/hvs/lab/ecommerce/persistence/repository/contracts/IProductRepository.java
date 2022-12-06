package com.hvs.lab.ecommerce.persistence.repository.contracts;

import com.hvs.lab.ecommerce.persistence.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<ProductEntity, Long> {
}
