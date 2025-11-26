package com.ram.javabackend.controller;

import java.util.Map;
import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ram.javabackend.dto.LoginRequest;
import com.ram.javabackend.dto.UserDto;
import com.ram.javabackend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto dto) {
        String msg = authService.register(dto);
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest req) {
        String token = authService.login(req.getEmail(), req.getPassword());
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
    
}

