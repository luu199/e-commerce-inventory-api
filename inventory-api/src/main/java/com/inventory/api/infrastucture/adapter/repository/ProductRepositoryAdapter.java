package com.inventory.api.infrastucture.adapter.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.ProductRepositoryPort;
import com.inventory.api.infrastucture.adapter.entity.ProductEntity;

@Component 
public class ProductRepositoryAdapter implements ProductRepositoryPort{
    
    private final SpringDataProductRepository jpaRepository;

    public ProductRepositoryAdapter(SpringDataProductRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    @Override
    public Product save(Product product) {
        ProductEntity entity = toEntity(product);
        ProductEntity savedEntity = jpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    // Mappers internos
    private ProductEntity toEntity(Product product) {
        return new ProductEntity(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }

    private Product toDomain(ProductEntity entity) {
        return new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getStock());
    }
}
