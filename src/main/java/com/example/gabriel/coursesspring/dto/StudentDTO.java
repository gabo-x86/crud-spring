package com.example.gabriel.coursesspring.dto;

import com.example.gabriel.coursesspring.domain.entities.StudentIdCard;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Forma simple de implementar getters/setters/toString
@Getter
@Setter
@ToString
public class StudentDTO {

    //Para tabla student
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    //Para tabla student_id_card
    private String cardNumber;

    public StudentDTO(){
    }
}
