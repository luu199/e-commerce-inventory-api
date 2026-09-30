package com.inventory.api.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest {

     private Product createProduct(int stock) {
        return new Product(1L, "Laptop", "Laptop de prueba", new BigDecimal("2500.00"), stock);
    }

    @Test
    @DisplayName("Reduce el stock cuando hay unidades suficientes")
    void reduceStock_whenEnoughStock_decreasesStock() {
        Product product = createProduct(10);

        product.reduceStock(3);

        assertEquals(7, product.getStock());
    }

    @Test
    @DisplayName("Permite dejar el stock en cero")
    void reduceStock_whenQuantityEqualsStock_leavesZero() {
        Product product = createProduct(5);

        product.reduceStock(5);

        assertEquals(0, product.getStock());
    }

    @Test
    @DisplayName("Lanza excepción y no modifica el stock si no hay suficiente")
    void reduceStock_whenNotEnoughStock_throwsException() {
        Product product = createProduct(2);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> product.reduceStock(5));

        assertEquals("Stock insuficiente para realizar la operación", ex.getMessage());
        assertEquals(2, product.getStock());
    }
}
