package com.richiecodes.inventorymanager.repository;

import com.richiecodes.inventorymanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
