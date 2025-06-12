package com.smartbuyhub.data;

import com.smartbuyhub.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    /*public Page<User> findUsersByFilters(String username, String city, String state, Pageable pageable) {
        // implement this using Specification or QueryDSL or a custom JPA query
    }*/
}


