package com.example.gabriel.coursesspring.services;

import com.example.gabriel.coursesspring.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    public List<CourseDTO> listCourses();
    public CourseDTO saveCourse(CourseDTO courseDTO);
    Optional<CourseDTO> getCourseById(Integer courseId);
    public void delete(Integer courseId);
}
