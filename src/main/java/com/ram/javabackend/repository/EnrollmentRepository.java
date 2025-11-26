package com.ram.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.javabackend.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    
}
