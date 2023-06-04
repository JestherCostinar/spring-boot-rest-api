package com.jesthercostinar.springboot.controller;

import com.jesthercostinar.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    // Spring Boot REST API using GetMapping
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Jesther", "Costinar");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
