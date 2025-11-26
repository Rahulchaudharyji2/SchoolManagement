package com.ram.javabackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ram.javabackend.dto.CourseDto;
import com.ram.javabackend.entity.Course;
import com.ram.javabackend.exception.ResourcesNotFoundException;
import com.ram.javabackend.repository.CourseRepository;
import com.ram.javabackend.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;

    public CourseServiceImpl(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public CourseDto createCourse(CourseDto dto) {
        Course c = new Course();
        c.setName(dto.getName());
        c.setDescription(dto.getDescription());

        Course saved = courseRepo.save(c);
        return mapToDto(saved);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course c = courseRepo.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Course not found"));

        return mapToDto(c);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCourse(Long id) {
        Course c = courseRepo.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Course not found"));
        courseRepo.delete(c);
    }

    private CourseDto mapToDto(Course c) {
        CourseDto dto = new CourseDto();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setDescription(c.getDescription());
        return dto;
    }
}
