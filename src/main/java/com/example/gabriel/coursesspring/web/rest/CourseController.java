package com.example.gabriel.coursesspring.web.rest;

import com.example.gabriel.coursesspring.CoursesSpringApplication;
import com.example.gabriel.coursesspring.dto.CourseDTO;
import com.example.gabriel.coursesspring.services.CourseService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {
    private static final Logger log = LoggerFactory.getLogger(CoursesSpringApplication.class);

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> listAllCourses(){
        return ResponseEntity.ok().body(this.courseService.listCourses());
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody final CourseDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("A new course should not have an id");
        }

        CourseDTO courseDTO = this.courseService.saveCourse(dto);

        return ResponseEntity
                .created(new URI("/v1/courses/"+courseDTO.getId()))
                .body(courseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> editCourse(@RequestBody final CourseDTO dto,
                                                @PathVariable final Integer id){
        if(dto == null){
            throw new IllegalArgumentException("There isn't data");
        }

        //No creo que sea necesario ser redundanto con el id del REQUESTBODY
        // y con el parametro pasado en la ruta
        //AHORA TIENE SENTIDO, EL CLIENTE TIENE QUE ENVIAR EL JSON CON ID SI O SI PORQUE LO OBTUVO CON UNA CONSULTA PREVIA
        if(!Objects.equals(dto.getId(), id)){
            throw new IllegalArgumentException("Invalid course id");
        }

        return ResponseEntity
                .ok()
                .body(this.courseService.saveCourse(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id){
        this.courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
