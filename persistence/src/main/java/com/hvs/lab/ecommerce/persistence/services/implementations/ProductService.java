package com.hvs.lab.ecommerce.persistence.services.implementations;

import com.hvs.lab.ecommerce.persistence.entities.ProductEntity;
import com.hvs.lab.ecommerce.persistence.repository.contracts.IProductRepository;
import com.hvs.lab.ecommerce.persistence.services.contracts.IProductService;
import com.hvs.lab.shared.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        return modelMapper.map(productRepository.save(productEntity), Product.class);
    }
}
