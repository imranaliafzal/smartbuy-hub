package com.smartbuyhub.data;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartbuyhub.domain.Product;


public interface ProductRepository extends JpaRepository<Product, UUID> {
    // You can add custom query methods here if needed
}
