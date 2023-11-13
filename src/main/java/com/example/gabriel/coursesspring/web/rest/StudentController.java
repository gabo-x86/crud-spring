package com.example.gabriel.coursesspring.web.rest;

import com.example.gabriel.coursesspring.domain.entities.Student;
import com.example.gabriel.coursesspring.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> listStudents(){
        return ResponseEntity.ok().body(this.studentService.listStudents());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody final Student student) throws URISyntaxException {
        if(student.getId() != null){
            // EXCEPCION LANZADA PORQUE NO PODEMOS MANDAR UN BODY CON ID
            // LOS ID SE GENERAN AUTOMATICAMENTE
            throw new IllegalArgumentException("A new student cannot have an id");
        }
        Student studentDB = this.studentService.save(student);
        return ResponseEntity.created(new URI("/v1/students/"+studentDB.getId())).body(studentDB);
    }
}
