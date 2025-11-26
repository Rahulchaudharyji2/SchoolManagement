package com.ram.javabackend.service;

import com.ram.javabackend.dto.CourseDto;
import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto dto);
    CourseDto getCourseById(Long id);
    List<CourseDto> getAllCourses();
    void deleteCourse(Long id);
}
