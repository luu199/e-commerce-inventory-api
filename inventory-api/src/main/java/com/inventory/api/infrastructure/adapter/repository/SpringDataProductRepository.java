package com.inventory.api.infrastructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.api.infrastructure.adapter.entity.ProductEntity;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity,Long> {
}
