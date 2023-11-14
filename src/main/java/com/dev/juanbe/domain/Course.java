package com.dev.juanbe.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @Column(name = "id_course", nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer idCourse;

    @Column(name = "name", length = 100)
    private String name;

    @ManyToMany(mappedBy = "courseStudent")
    Set<Student> courseStudent;

}
