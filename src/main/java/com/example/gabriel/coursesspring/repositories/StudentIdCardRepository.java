package com.example.gabriel.coursesspring.repositories;

import com.example.gabriel.coursesspring.domain.entities.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {
}
