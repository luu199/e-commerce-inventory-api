package com.inventory.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.inventory.api.domain.model.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    
} 