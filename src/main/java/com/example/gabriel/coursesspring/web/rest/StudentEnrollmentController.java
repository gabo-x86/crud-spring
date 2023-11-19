package com.example.gabriel.coursesspring.web.rest;

import com.example.gabriel.coursesspring.domain.entities.Enrollment;
import com.example.gabriel.coursesspring.services.EnrollmentService;
import org.apache.coyote.Response;
import org.aspectj.apache.bcel.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/students/{studentId}/enrollments")
public class StudentEnrollmentController {
    private final EnrollmentService enrollmentService;

    public StudentEnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> listEnrollments(@PathVariable final Integer studentId){
        return ResponseEntity.ok().body(this.enrollmentService.getEnrollmentByStudentId(studentId));
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody final Enrollment enrollment) throws URISyntaxException {
        if(enrollment.getId() != null){
            throw new IllegalArgumentException("A new enrollment shouldn't has an id");
        }
        enrollment.setCreatedAt(LocalDateTime.now());
        Enrollment enrollmentDB = this.enrollmentService.save(enrollment);

        return ResponseEntity
                .created(new URI("/v1/students" + enrollmentDB.getStudent().getId() + "/enrollments/" + enrollmentDB.getId()))
                .body(enrollmentDB);
    }
}
