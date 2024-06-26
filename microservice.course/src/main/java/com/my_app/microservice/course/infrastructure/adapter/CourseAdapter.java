package com.my_app.microservice.course.infrastructure.adapter;

import com.my_app.microservice.course.client.StudentClient;
import com.my_app.microservice.course.domain.entities.Course;
import com.my_app.microservice.course.domain.service.CourseService;
import com.my_app.microservice.course.infrastructure.api.dto.response.StudentByCourseResponse;
import com.my_app.microservice.course.infrastructure.repository.CourseRepository;
import com.my_app.microservice.course.infrastructure.repository.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAdapter implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //importar cliente que comunica el microservicio
    @Autowired
    private StudentClient studentClient;


    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long courseId) {

        //Consulta el curso
        Course course = courseRepository.findById(courseId).orElse(new Course());
        //Obtiene la lista de estudiantes del curso
        List<StudentDto> studentDtoList = studentClient.findAllStudentsByCourse(courseId);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDtoList(studentDtoList)
                .build();
    }
}
