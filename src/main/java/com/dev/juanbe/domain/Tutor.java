package com.dev.juanbe.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Tutor {

    @Id
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
    @Column(name = "id_tutor", nullable = false, updatable = false)
    private Integer idTutor;

    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private Set<Student> students;
}
