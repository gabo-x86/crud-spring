package com.example.gabriel.coursesspring.services.mapper;

import com.example.gabriel.coursesspring.domain.entities.Course;
import com.example.gabriel.coursesspring.dto.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper implements CustomMapper<CourseDTO, Course>{

    /**
     * Método para convertir a DTO
     * */
    @Override
    public CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDepartment(course.getDepartment());

        return courseDTO;
    }

    /**
     * Método para convertir a Entity Course
     * */
    @Override
    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setDepartment(courseDTO.getDepartment());

        return course;
    }
}
