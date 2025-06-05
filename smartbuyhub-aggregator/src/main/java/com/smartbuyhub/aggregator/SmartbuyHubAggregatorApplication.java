package com.smartbuyhub.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.smartbuyhub")
//@SpringBootApplication(scanBasePackages = {"com.smartbuyhub.aggregator", "com.smartbuyhub.catalog"})
public class SmartbuyHubAggregatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartbuyHubAggregatorApplication.class, args);
    }
}