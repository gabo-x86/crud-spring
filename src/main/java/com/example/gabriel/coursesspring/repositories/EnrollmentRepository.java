package com.example.gabriel.coursesspring.repositories;

import com.example.gabriel.coursesspring.domain.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    /**
     * Aqui se está haciendo un query para hacer un filtro inicial
     * */
    List<Enrollment> findAllByStudent_IdOrderById(Integer studentId);
}
