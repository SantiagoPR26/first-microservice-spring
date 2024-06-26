package com.my_app.microservice.student.infrastructure.repository.student;

import com.my_app.microservice.student.domain.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {


    List<Student> findAllByCourseId(Long idCourse);
}
