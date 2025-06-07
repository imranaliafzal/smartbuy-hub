package com.smartbuyhub.auth;

import com.smartbuyhub.auth.entity.Role;
import com.smartbuyhub.auth.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(RoleRepository roleRepository) {
        return args -> {
            // Initialize roles if they don't exist
            if (roleRepository.count() == 0) {
                Role userRole = new Role();
                userRole.setName(Role.ERole.ROLE_USER);
                roleRepository.save(userRole);

                Role adminRole = new Role();
                adminRole.setName(Role.ERole.ROLE_ADMIN);
                roleRepository.save(adminRole);
            }
        };
    }
} 