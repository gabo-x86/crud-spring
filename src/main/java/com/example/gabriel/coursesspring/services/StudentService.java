package com.example.gabriel.coursesspring.services;

import com.example.gabriel.coursesspring.domain.entities.Student;

import java.util.List;

public interface StudentService {
    public List<Student> listStudents();
    public Student save(Student student);

}
