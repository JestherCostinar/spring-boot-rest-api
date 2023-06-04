package com.jesthercostinar.springboot.controller;

import com.jesthercostinar.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // Spring Boot REST API using GetMapping that return JSON
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Jesther", "Costinar");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Spring REST API that return a list in JSON format
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents() {
        List <Student> students = new ArrayList<>();
        students.add(new Student(1, "Jesther", "Costinar"));
        students.add(new Student(2, "Jersey", "Alto"));
        students.add(new Student(3, "Franken", "Alto"));
        return ResponseEntity.ok(students);

    }
}
