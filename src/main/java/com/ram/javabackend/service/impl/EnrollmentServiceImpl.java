package com.ram.javabackend.service.impl;

import org.springframework.stereotype.Service;

import com.ram.javabackend.dto.EnrollmentDto;
import com.ram.javabackend.entity.Course;
import com.ram.javabackend.entity.Enrollment;
import com.ram.javabackend.entity.Student;
import com.ram.javabackend.exception.ResourcesNotFoundException;
import com.ram.javabackend.repository.CourseRepository;
import com.ram.javabackend.repository.EnrollmentRepository;
import com.ram.javabackend.repository.StudentRepository;
import com.ram.javabackend.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public EnrollmentServiceImpl(
            EnrollmentRepository enrollmentRepo,
            StudentRepository studentRepo,
            CourseRepository courseRepo
    ) {
        this.enrollmentRepo = enrollmentRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public EnrollmentDto enrollStudent(EnrollmentDto dto) {

        Student student = studentRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourcesNotFoundException("Student not found"));

        Course course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourcesNotFoundException("Course not found"));

        Enrollment e = new Enrollment();
        e.setStudent(student);
        e.setCourse(course);

        Enrollment saved = enrollmentRepo.save(e);

        EnrollmentDto response = new EnrollmentDto();
        response.setId(saved.getId());
        response.setStudentId(saved.getStudent().getId());
        response.setCourseId(saved.getCourse().getId());

        return response;
    }
}
