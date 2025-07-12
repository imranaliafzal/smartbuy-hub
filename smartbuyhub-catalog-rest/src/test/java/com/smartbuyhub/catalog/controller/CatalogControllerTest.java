package com.smartbuyhub.catalog.controller;

import com.smartbuyhub.catalog.model.ProductDTO;
import com.smartbuyhub.catalog.rest.CatalogServiceApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CatalogServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllProducts() {
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(
                "/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDTO>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<ProductDTO> products = response.getBody();

        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertEquals("Red Shirt", products.get(0).getName());
    }
    @Test
    void getHello(){
        ResponseEntity<String> response = restTemplate.exchange(
                "/products/hello",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        String helloString = response.getBody();

        assertNotNull(helloString);
        assertFalse(helloString.isEmpty());
    }

    @Test
    void getProductById() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void importProducts() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void deactivateProduct() {
    }

    @Test
    void addProduct() {
    }
}