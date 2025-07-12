package com.smartbuyhub.catalog.controller;

import com.smartbuyhub.catalog.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.smartbuyhub.catalog.service.CatalogService;
import com.smartbuyhub.domain.Product;
import com.smartbuyhub.catalog.mapper.ProductMapper;

import java.time.OffsetDateTime;
import java.util.*;

@RestController
@RequestMapping("/products")
public class CatalogController {

    private final Map<UUID, ProductDTO> mockDatabase = new HashMap<>();

    private final CatalogService catalogService;
    private final ProductMapper productMapper;

    public CatalogController(CatalogService catalogService, ProductMapper productMapper) {
        this.catalogService = catalogService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
    	List<Product> products = catalogService.getAll();
        List<ProductDTO> productDTOs = productMapper.toDTOList(products);
        return ResponseEntity.ok(productDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID id) {
        ProductDTO product = mockDatabase.get(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }
    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hello World");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable UUID id, @RequestBody ProductDTO product) {
        product.setId(id);
        product.setUpdatedAt(OffsetDateTime.now());
        mockDatabase.put(id, product);
        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity<String> importProducts(@RequestBody List<ProductDTO> products) {
        for (ProductDTO product : products) {
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
        ProductDTO product = mockDatabase.get(id);
        if (product != null) {
            product.setIsActive(false);
            product.setUpdatedAt(OffsetDateTime.now());
            return ResponseEntity.ok("Product marked as inactive");
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product){
    	product.setUpdatedAt(OffsetDateTime.now());
    	product.setCreatedAt(OffsetDateTime.now());
    	product.setCreatedBy("admin");
    	product.setUpdatedBy("admin");
    	Product rslt = catalogService.add(productMapper.toEntity(product));
    	return ResponseEntity.ok(productMapper.toDTO(rslt));
    }
}
