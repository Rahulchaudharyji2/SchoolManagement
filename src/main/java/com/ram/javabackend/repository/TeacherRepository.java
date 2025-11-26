package com.ram.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.javabackend.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}
