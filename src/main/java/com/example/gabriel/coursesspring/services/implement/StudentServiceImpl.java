package com.example.gabriel.coursesspring.services.implement;

import com.example.gabriel.coursesspring.domain.entities.Student;
import com.example.gabriel.coursesspring.repositories.StudentRespository;
import com.example.gabriel.coursesspring.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRespository studentRespository;

    public StudentServiceImpl(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }

    @Override
    public List<Student> listStudents() {
        return this.studentRespository.findAll();
    }

    @Override
    public Student save(Student student) {
        return this.studentRespository.save(student);
    }
}
