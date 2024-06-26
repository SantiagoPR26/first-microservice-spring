package com.my_app.microservice.course.infrastructure.api.controller;

import com.my_app.microservice.course.domain.entities.Course;
import com.my_app.microservice.course.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> findAllCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/search-students/{courseId}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long courseId){
      return ResponseEntity.ok(courseService.findStudentsByIdCourse(courseId));
    }
}
