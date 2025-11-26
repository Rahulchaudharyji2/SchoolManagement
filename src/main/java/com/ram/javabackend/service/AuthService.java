package com.ram.javabackend.service;

import com.ram.javabackend.dto.UserDto;
import com.ram.javabackend.dto.LoginRequest;

public interface AuthService {
    String register(UserDto dto);
    String login(String email, String password);  // <-- email + password
}

