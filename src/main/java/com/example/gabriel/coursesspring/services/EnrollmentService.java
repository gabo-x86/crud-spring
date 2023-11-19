package com.example.gabriel.coursesspring.services;

import com.example.gabriel.coursesspring.domain.entities.Enrollment;

import java.util.List;

public interface EnrollmentService {

    public List<Enrollment> getEnrollmentByStudentId(Integer studentId);

    public Enrollment save(Enrollment enrollment);
}
