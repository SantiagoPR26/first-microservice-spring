package com.my_app.microservice.course.client;

import com.my_app.microservice.course.infrastructure.repository.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
public interface StudentClient {

    @GetMapping("/search-by-course/{courseId}")
    List<StudentDto> findAllStudentsByCourse(@PathVariable Long courseId);
}
