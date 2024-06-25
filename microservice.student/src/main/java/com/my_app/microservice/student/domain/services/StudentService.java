package com.my_app.microservice.student.domain.services;

import com.my_app.microservice.student.domain.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findByIdCourse(Long idCourse);
}
