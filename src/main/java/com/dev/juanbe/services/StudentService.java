package com.dev.juanbe.services;

import com.dev.juanbe.model.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public interface StudentService {

    List<StudentDTO> finAll();
    StudentDTO getByDni(Integer dni);
    Integer create(StudentDTO studentDTO);
    void update(Integer idStudent, StudentDTO studentDTO);
    void delete(Integer idStudent);
}
