package com.dev.juanbe.model;
import lombok.Data;
import java.util.Set;

@Data
public class StudentDTO {
    private Integer idStudent;
    private Integer dni;
    private String name;
    private TutorDTO tutor;
    private Set<CourseDTO> courses;

}

