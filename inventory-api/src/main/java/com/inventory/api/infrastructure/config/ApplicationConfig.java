package com.inventory.api.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inventory.api.domain.repository.ProductRepositoryPort;
import com.inventory.api.domain.service.ProductService;

@Configuration 
public class ApplicationConfig {

    @Bean
    public ProductService productService(ProductRepositoryPort productRepositoryPort) {
        return new ProductService(productRepositoryPort);
    }
}
