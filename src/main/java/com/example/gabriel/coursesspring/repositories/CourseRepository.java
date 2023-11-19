package com.example.gabriel.coursesspring.repositories;

import com.example.gabriel.coursesspring.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
