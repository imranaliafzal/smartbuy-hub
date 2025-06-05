package com.smartbuyhub.catalog.controller;

import com.smartbuyhub.catalog.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.*;

@RestController
@RequestMapping("/products")
public class CatalogController {

    private final Map<UUID, Product> mockDatabase = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(new ArrayList<>(mockDatabase.values()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        Product product = mockDatabase.get(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product product) {
        product.setId(id);
        product.setUpdatedAt(OffsetDateTime.now());
        mockDatabase.put(id, product);
        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity<String> importProducts(@RequestBody List<Product> products) {
        for (Product product : products) {
            if (product.getId() == null) {
                product.setId(UUID.randomUUID());
            }
            product.setCreatedAt(OffsetDateTime.now());
            product.setUpdatedAt(OffsetDateTime.now());
            mockDatabase.put(product.getId(), product);
        }
        return ResponseEntity.ok("Products imported successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        mockDatabase.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivateProduct(@PathVariable UUID id) {
        Product product = mockDatabase.get(id);
        if (product != null) {
            product.setIsActive(false);
            product.setUpdatedAt(OffsetDateTime.now());
            return ResponseEntity.ok("Product marked as inactive");
        }
        return ResponseEntity.notFound().build();
    }
}
