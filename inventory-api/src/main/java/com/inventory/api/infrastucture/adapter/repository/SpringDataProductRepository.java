package com.inventory.api.infrastucture.adapter.repository;

import com.inventory.api.infrastucture.adapter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity,Long> {
}
