package com.example.gabriel.coursesspring.services.implement;

import com.example.gabriel.coursesspring.domain.entities.Student;
import com.example.gabriel.coursesspring.domain.entities.StudentIdCard;
import com.example.gabriel.coursesspring.dto.StudentDTO;
import com.example.gabriel.coursesspring.repositories.StudentIdCardRepository;
import com.example.gabriel.coursesspring.repositories.StudentRespository;
import com.example.gabriel.coursesspring.services.StudentService;
import com.example.gabriel.coursesspring.services.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRespository studentRespository;
    private final StudentMapper studentMapper;
    private final StudentIdCardRepository studentIdCardRepository;

    public StudentServiceImpl(StudentRespository studentRespository, StudentMapper studentMapper, StudentIdCardRepository studentIdCardRepository) {
        this.studentRespository = studentRespository;
        this.studentMapper = studentMapper;
        this.studentIdCardRepository = studentIdCardRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> listStudents() {
        return this.studentRespository.findAll()
                .stream()
                .map(this.studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> listStudentsDetailed() {
        return this.studentRespository.findAll()
                .stream()
                .map(this.studentMapper::toDTODetailed)
                .collect(Collectors.toList());
    }

    /**
     * NOTA:
     * El DTO tiene data de dos ENTITY
     * pero al momento de persistir lo hacemos en sus respectivas tablas
     * */
    @Override
    public StudentDTO save(StudentDTO dto) {
        //GUARDAMOS ENTIDAD DTO STUDENT PERO CONVIRTIENDOLO A ENTITY
        Student student = this.studentRespository.save(this.studentMapper.toEntity(dto));

        if(dto.getCardNumber() != null){
            //INSTANCIAMOS ENTITY StudentIdCard y la guardamos
            StudentIdCard idCard = new StudentIdCard(dto.getCardNumber(), student);
            this.studentIdCardRepository.save(idCard);
        }

        return this.studentMapper.toDTO(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StudentDTO> getStudentById(Integer id) {
        return this.studentRespository.findById(id)
                .map(this.studentMapper::toDTO);
    }

    @Override
    public void deleteStudent(Integer id) {
        this.studentRespository.deleteById(id);
    }

}
