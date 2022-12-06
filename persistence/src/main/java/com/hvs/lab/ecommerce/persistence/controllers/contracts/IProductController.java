package com.hvs.lab.ecommerce.persistence.controllers.contracts;

import com.hvs.lab.shared.models.Product;

public interface IProductController {
    Product save(Product product);
}
