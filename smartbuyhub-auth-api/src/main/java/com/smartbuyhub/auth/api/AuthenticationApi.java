package com.smartbuyhub.auth.api;

import com.smartbuyhub.auth.api.model.JwtResponse;
import com.smartbuyhub.auth.api.model.LoginRequest;
import com.smartbuyhub.auth.api.model.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@RequestMapping("/api/auth")
public interface AuthenticationApi {
    
    @PostMapping("/signin")
    ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);
    
    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest);
} 