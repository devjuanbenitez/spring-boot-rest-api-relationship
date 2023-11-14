package com.dev.juanbe.repos;

import com.dev.juanbe.domain.Course;
import com.dev.juanbe.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course,Integer> {
}
