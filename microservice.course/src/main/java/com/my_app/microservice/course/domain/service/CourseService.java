package com.my_app.microservice.course.domain.service;

import com.my_app.microservice.course.domain.entities.Course;
import com.my_app.microservice.course.infrastructure.api.dto.response.StudentByCourseResponse;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    StudentByCourseResponse findStudentsByIdCourse(Long courseId);
}
