package com.example.gabriel.coursesspring.repositories;

import com.example.gabriel.coursesspring.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Student, Integer> {

}
