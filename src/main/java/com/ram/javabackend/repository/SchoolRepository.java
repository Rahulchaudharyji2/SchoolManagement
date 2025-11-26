package com.ram.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.javabackend.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
    
}
