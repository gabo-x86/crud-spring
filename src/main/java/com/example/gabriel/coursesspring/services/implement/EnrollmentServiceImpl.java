package com.example.gabriel.coursesspring.services.implement;

import com.example.gabriel.coursesspring.domain.entities.Enrollment;
import com.example.gabriel.coursesspring.repositories.EnrollmentRepository;
import com.example.gabriel.coursesspring.services.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }


    @Override
    public List<Enrollment> getEnrollmentByStudentId(Integer studentId) {
        /**
         * Filtrar en el lado de backend para registros < 1000
         * Filtrar en el lado de la BD para registros >10000
         * */
        return this.enrollmentRepository.findAllByStudent_IdOrderById(studentId);
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return this.enrollmentRepository.save(enrollment);
    }
}
