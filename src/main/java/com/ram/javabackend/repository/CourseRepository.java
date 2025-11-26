package com.ram.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.javabackend.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
