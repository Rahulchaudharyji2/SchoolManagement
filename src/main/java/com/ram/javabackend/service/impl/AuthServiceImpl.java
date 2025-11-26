package com.ram.javabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ram.javabackend.dto.UserDto;
import com.ram.javabackend.dto.LoginRequest;
import com.ram.javabackend.entity.User;
import com.ram.javabackend.repository.UserRepository;
import com.ram.javabackend.security.JwtUtil;
import com.ram.javabackend.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String register(UserDto dto) {

        if (userRepo.existsByEmail(dto.getEmail())) {
            return "Email already exists!!";
        }

        if (userRepo.existsByUsername(dto.getUsername())) {
            return "Username already exists!!";
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(java.util.List.of("USER"));

        userRepo.save(user);

        return "User Registered Successfully";
    }

@Override
public String login(String email, String password) {

    User user = userRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new RuntimeException("Invalid password");
    }

    return jwtUtil.generateToken(user.getEmail());
}



}
