package com.smartbuyhub.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.smartbuyhub.auth",
    "com.smartbuyhub.data",
    "com.smartbuyhub.domain"
})
@EnableJpaRepositories(basePackages = "com.smartbuyhub.data")
@EntityScan(basePackages = "com.smartbuyhub.domain")
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
} 