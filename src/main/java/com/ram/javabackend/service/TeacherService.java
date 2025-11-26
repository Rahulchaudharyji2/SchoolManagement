package com.ram.javabackend.service;

import com.ram.javabackend.dto.TeacherDto;
import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto dto);
    List<TeacherDto> getAllTeachers();
}
