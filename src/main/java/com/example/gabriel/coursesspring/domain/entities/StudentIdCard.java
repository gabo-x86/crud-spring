package com.example.gabriel.coursesspring.domain.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student_id_card")
public class StudentIdCard implements Serializable {
    private static final long serialVersionDTO = 8654658132165136L;

    @Id
    @SequenceGenerator(name = "my_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    //PARTE DE DECLARAR COMO RELACION BIDIRECCIONAL
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentIdCard(){
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
