package com.ram.javabackend.controller;

import com.ram.javabackend.dto.EnrollmentDto;
import com.ram.javabackend.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentDto> enrollStudent(@RequestBody EnrollmentDto dto) {
        return ResponseEntity.ok(enrollmentService.enrollStudent(dto));
    }
}
