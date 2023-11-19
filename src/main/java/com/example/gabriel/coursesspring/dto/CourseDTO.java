package com.example.gabriel.coursesspring.dto;


import java.io.Serializable;

/**
 * Este es un DTO
 * */
public class CourseDTO implements Serializable {

    private static final long serialVersionUID = 8979665446518L; //ESte debe ser un id único
    private Integer id;
    private String name;
    private String department;

    public CourseDTO(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
