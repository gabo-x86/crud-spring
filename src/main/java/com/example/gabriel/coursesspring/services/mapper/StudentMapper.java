package com.example.gabriel.coursesspring.services.mapper;

import com.example.gabriel.coursesspring.domain.entities.Student;
import com.example.gabriel.coursesspring.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements CustomMapper<StudentDTO, Student>{
    @Override
    public StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());

        return dto;
    }

    public StudentDTO toDTODetailed(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());
        if(student.getStudentIdCard() != null){
            dto.setCardNumber(student.getStudentIdCard().getCardNumber());
        }

        return dto;
    }

    @Override
    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());

        return student;
    }
}
