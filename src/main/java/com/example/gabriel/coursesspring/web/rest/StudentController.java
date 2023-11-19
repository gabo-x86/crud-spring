package com.example.gabriel.coursesspring.web.rest;

import com.example.gabriel.coursesspring.domain.entities.Student;
import com.example.gabriel.coursesspring.dto.StudentDTO;
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
    public ResponseEntity<List<StudentDTO>> listStudents(@RequestParam(required = false, defaultValue = "false") boolean detailed){
        if(detailed){
            return ResponseEntity
                    .ok()
                    .body(this.studentService.listStudentsDetailed());
        }else{
            return ResponseEntity
                    .ok()
                    .body(this.studentService.listStudents());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable final Integer id){
        return ResponseEntity
                .ok()
                .body(this.studentService.getStudentById(id).orElseThrow(
                        () -> new IllegalArgumentException("Resource not found exception for id: "+id)
                ));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody final StudentDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            // EXCEPCION LANZADA PORQUE NO PODEMOS MANDAR UN BODY CON ID
            // LOS ID SE GENERAN AUTOMATICAMENTE
            throw new IllegalArgumentException("A new student cannot have an id");
        }
        StudentDTO studentDTO = this.studentService.save(dto);
        return ResponseEntity.created(new URI("/v1/students/"+studentDTO.getId())).body(studentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id){
        this.studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
