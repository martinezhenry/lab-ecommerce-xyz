package com.hvs.lab.ecommerce.persistence.services.contracts;

import com.hvs.lab.shared.models.Product;

public interface IProductService {
    Product save(Product product);
}
