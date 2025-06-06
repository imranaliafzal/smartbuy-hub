package com.smartbuyhub.catalog.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.smartbuyhub.data")
@EntityScan(basePackages = "com.smartbuyhub.domain")
@SpringBootApplication(scanBasePackages = "com.smartbuyhub")
public class CatalogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }
}