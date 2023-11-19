package com.example.gabriel.coursesspring.services.implement;

import com.example.gabriel.coursesspring.domain.entities.Course;
import com.example.gabriel.coursesspring.dto.CourseDTO;
import com.example.gabriel.coursesspring.repositories.CourseRepository;
import com.example.gabriel.coursesspring.services.CourseService;
import com.example.gabriel.coursesspring.services.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    /**
     * Notar que cuando usamos dto tenemos que declarar el MAPPER como constante
     * */
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDTO> listCourses() {
        //RECUPERAMOS LA LISTA DE COURSES
        List<Course> courses = courseRepository.findAll(); //Usamos repository
        //LOS CONVERTIMOS A UN DTO Y LO DEVOLVEMOS
        return courses.stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());//Convertir a DTO
    }

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        //RECIBIMOS UN DTO
        Course course = this.courseMapper.toEntity(courseDTO); //Convertir dto que llega del cliente a ENTITY
        //GUARDAMOS UN ENTITY
        return this.courseMapper.toDTO(this.courseRepository.save(course)); //Dentro el save se guarda el ENTITY Course
    }

    @Override
    public Optional<CourseDTO> getCourseById(Integer courseId) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer courseId) {
        this.courseRepository.deleteById(courseId);
    }
}
