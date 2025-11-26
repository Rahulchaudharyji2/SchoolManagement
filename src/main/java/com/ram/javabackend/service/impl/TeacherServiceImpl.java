package com.ram.javabackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ram.javabackend.dto.TeacherDto;
import com.ram.javabackend.entity.Teacher;
import com.ram.javabackend.repository.TeacherRepository;
import com.ram.javabackend.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepo;

    public TeacherServiceImpl(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public TeacherDto createTeacher(TeacherDto dto) {
        Teacher t = new Teacher();
        t.setName(dto.getName());
        t.setSubject(dto.getSubject());

        Teacher saved = teacherRepo.save(t);
        return mapToDto(saved);
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return teacherRepo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private TeacherDto mapToDto(Teacher t) {
        TeacherDto dto = new TeacherDto();
        dto.setId(t.getId());
        dto.setName(t.getName());
        dto.setSubject(t.getSubject());
        return dto;
    }
}
