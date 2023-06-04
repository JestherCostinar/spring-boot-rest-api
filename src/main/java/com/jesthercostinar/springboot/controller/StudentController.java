package com.jesthercostinar.springboot.controller;

import com.jesthercostinar.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Get Mapping with Path Variable
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getSudentPathVariable(@PathVariable("id") int studentId,
                                                         @PathVariable("first-name") String firstName,
                                                         @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Get Mapping with Query Parameter
    @GetMapping("/query")
    public ResponseEntity<Student> getStudentQuery(@RequestParam int id,
                                                   @RequestParam String firstName,
                                                   @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // POST Mapping - Create student record
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // PutMapping - Update student record
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                                 @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(studentId);
        return ResponseEntity.ok(student);
    }
}
