package com.smartbuyhub;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;

@EnableJpaRepositories(basePackages = "com.smartbuyhub.data")
@EntityScan(basePackages = "com.smartbuyhub.domain")
@SpringBootApplication
@ComponentScan(basePackages = {
    "com.smartbuyhub.rest",
    "com.smartbuyhub.auth",
    "com.smartbuyhub.catalog"
})
public class SmartbuyhubRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartbuyhubRestApplication.class, args);
    }
    
    @Autowired
    ApplicationContext applicationContext;

	/*
	 * @PostConstruct public void printBeans() { for (String name :
	 * applicationContext.getBeanDefinitionNames()) { System.out.println(name); } }
	 */
}