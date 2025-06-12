package com.smartbuyhub.user.controller;

import com.smartbuyhub.user.model.UserDTO;
import com.smartbuyhub.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userService = userMapper;
    }

    // Create a new user
    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        userDTO.setUpdatedAt(OffsetDateTime.now());
        userDTO.setCreatedAt(OffsetDateTime.now());
        userDTO.setCreatedBy("admin");
        userDTO.setUpdatedBy("admin");
        UserDTO rslt = userService.add(productMapper.toEntity(userDTO));
        return ResponseEntity.ok(productMapper.toDTO(rslt));
    }

    // Get a single user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a user by ID
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {
        Optional<User> existing = userService.getUserById(id);
        if (existing.isPresent()) {
            User user = existing.get();
            // Update mutable fields
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setFullname(updatedUser.getFullname());
            user.setStreet(updatedUser.getStreet());
            user.setCity(updatedUser.getCity());
            user.setState(updatedUser.getState());
            user.setZip(updatedUser.getZip());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            return ResponseEntity.ok(userService.saveUser(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    // Get all users with pagination and filtering
    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        Page<User> users = userService.findUsersByFilters(username, city, state, pageable);
        return ResponseEntity.ok(users);
    }
}
