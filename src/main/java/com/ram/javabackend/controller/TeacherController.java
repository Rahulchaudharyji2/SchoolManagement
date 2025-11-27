package com.ram.javabackend.controller;

import com.ram.javabackend.dto.TeacherDto;
import com.ram.javabackend.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto dto) {
        return ResponseEntity.ok(teacherService.createTeacher(dto));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }
}
