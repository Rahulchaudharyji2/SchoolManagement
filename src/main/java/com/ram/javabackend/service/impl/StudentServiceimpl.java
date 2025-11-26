package com.ram.javabackend.service.impl;

import com.ram.javabackend.entity.Student;
import com.ram.javabackend.repository.StudentRepository;
import com.ram.javabackend.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceimpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student updateStudent(Long id, Student newData) {
        Student old = getStudentById(id);

        old.setFirstName(newData.getFirstName());
        old.setLastName(newData.getLastName());
        old.setAge(newData.getAge());
        old.setCity(newData.getCity());
        old.setSchool(newData.getSchool());

        return repo.save(old);
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
