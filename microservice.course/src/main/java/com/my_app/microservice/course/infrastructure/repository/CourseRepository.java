package com.my_app.microservice.course.infrastructure.repository;

import com.my_app.microservice.course.domain.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
