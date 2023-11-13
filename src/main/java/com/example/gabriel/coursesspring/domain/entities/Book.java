package com.example.gabriel.coursesspring.domain.entities;

import jakarta.persistence.*;

public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private Integer id;
    private String name;

    /**
     * LAZY → El join solo se ejecuta solo cuando se accede explícitamente a ella
     * EAGER → El join se ejecuta cuando se recupera la entidad principal.
     * */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    public Book(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public Book(){
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student getStudent() {
        return student;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
