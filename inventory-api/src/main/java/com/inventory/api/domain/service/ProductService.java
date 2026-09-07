package com.inventory.api.domain.service;

import java.util.List;

import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.ProductRepositoryPort;

public class ProductService {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    public Product createProduct(Product product){
        return productRepositoryPort.save(product);
    }
    
    public List<Product> getAllProducts(){
        return productRepositoryPort.findAll();
    }
}
