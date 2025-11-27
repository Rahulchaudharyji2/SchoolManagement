package com.ram.javabackend.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ram.javabackend.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        String authHeader = req.getHeader("Authorization");
        System.out.println("JwtFilter: Auth Header: " + authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtUtil.validate(token)) {
                String email = jwtUtil.extractSubject(token);
                System.out.println("JwtFilter: Valid token for email: " + email);
                userRepo.findByEmail(email).ifPresentOrElse(user -> {
                    System.out.println("JwtFilter: User found: " + user.getEmail());
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            java.util.Collections.emptyList());
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }, () -> System.out.println("JwtFilter: User NOT found in DB"));
            } else {
                System.out.println("JwtFilter: Invalid token");
            }
        }
        chain.doFilter(req, res);
    }
}
