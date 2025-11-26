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

@Component
public class JwtFilter extends OncePerRequestFilter {

  @Autowired
   private JwtUtil jwtUtil;
  @Autowired private UserRepository userRepo;

  @Override
  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws ServletException, IOException {

      String authHeader = req.getHeader("Authorization");
      if (authHeader != null && authHeader.startsWith("Bearer ")) {
          String token = authHeader.substring(7);
          if (jwtUtil.validate(token)) {
              String email = jwtUtil.extractSubject(token);
           
          }
      }
      chain.doFilter(req, res);
  }
}

