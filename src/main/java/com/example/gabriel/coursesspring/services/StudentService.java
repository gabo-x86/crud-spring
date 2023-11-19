package com.example.gabriel.coursesspring.services;

import com.example.gabriel.coursesspring.domain.entities.Student;
import com.example.gabriel.coursesspring.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<StudentDTO> listStudents();
    public List<StudentDTO> listStudentsDetailed();
    public StudentDTO save(StudentDTO student);
    public Optional<StudentDTO> getStudentById(Integer id);
    public void deleteStudent(Integer id);

}
