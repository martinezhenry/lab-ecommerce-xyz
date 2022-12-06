package com.hvs.lab.ecommerce.persistence.controllers.implementations;

import com.hvs.lab.ecommerce.persistence.controllers.contracts.IProductController;
import com.hvs.lab.ecommerce.persistence.services.contracts.IProductService;
import com.hvs.lab.shared.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hvs.lab.shared.components.constants.Path.PRODUCT;

@RestController
@RequestMapping(PRODUCT)
public class ProductController implements IProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Override
    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
}
