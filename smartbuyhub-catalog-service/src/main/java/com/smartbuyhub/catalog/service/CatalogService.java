package com.smartbuyhub.catalog.service;

import org.springframework.stereotype.Service;
import com.smartbuyhub.data.ProductRepository;
import com.smartbuyhub.domain.Product;

import java.util.List;


@Service
public class CatalogService {

    private final ProductRepository productRepository;

    public CatalogService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
    
    public Product add(Product product) {
    	return productRepository.save(product);
    }
}
