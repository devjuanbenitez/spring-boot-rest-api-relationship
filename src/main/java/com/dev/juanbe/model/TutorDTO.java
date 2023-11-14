package com.dev.juanbe.model;

import lombok.Data;
import java.util.Set;

@Data
public class TutorDTO {
    private Integer idTutor;
    private String name;
    private Set<StudentDTO> students;
}
