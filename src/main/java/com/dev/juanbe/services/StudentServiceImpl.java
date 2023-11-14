package com.dev.juanbe.services;

import com.dev.juanbe.domain.Course;
import com.dev.juanbe.domain.Student;
import com.dev.juanbe.domain.Tutor;
import com.dev.juanbe.model.CourseDTO;
import com.dev.juanbe.model.StudentDTO;
import com.dev.juanbe.model.TutorDTO;
import com.dev.juanbe.repos.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> finAll() {

        final List<Student> students = studentRepository.findAll(Sort.by("idStudent"));
        return students.stream()
                .map(student -> mapToDTO(student, new StudentDTO()))
                .toList();
    }

    @Override
    public StudentDTO getByDni(Integer dni) {
        return null;
    }

    @Transactional
    @Override
    public Integer create(StudentDTO studentDTO) {
        final Student student = new Student();
        mapToEntity(studentDTO, student);
        return studentRepository.save(student).getIdStudent();
    }

    @Override
    public void update(Integer idStudent, StudentDTO studentDTO) {
    }
    @Override
    public void delete(Integer idStudent) {
    }

    private StudentDTO mapToDTO(final Student student,final StudentDTO studentDTO){
        studentDTO.setIdStudent(student.getIdStudent());
        studentDTO.setDni(student.getDni());
        studentDTO.setName(student.getName());

        if (student.getTutor() != null){
                        TutorDTO tutor = new TutorDTO();
                        tutor.setIdTutor(student.getTutor().getIdTutor());
                        tutor.setName(student.getTutor().getName());
                        studentDTO.setTutor(tutor);
        }
        if (student.getCourseStudent() != null) {
            Set<CourseDTO> courses = student.getCourseStudent().stream()
                    .map(coursess -> {
                        CourseDTO course = new CourseDTO();
                        course.setIdCourse(coursess.getIdCourse());
                        course.setName(coursess.getName());
                        return course;
                    }).collect(Collectors.toSet());
            studentDTO.setCourses(courses);
        }
        return studentDTO;
    }
    private Student mapToEntity(final StudentDTO studentDTO, final Student student) {
        student.setIdStudent(studentDTO.getIdStudent());
        student.setDni(studentDTO.getDni());
        student.setName(studentDTO.getName());

        if (studentDTO.getTutor() != null) {
            Tutor tutor = new Tutor();
            tutor.setIdTutor(studentDTO.getTutor().getIdTutor());
            tutor.setName(studentDTO.getTutor().getName());
            student.setTutor(tutor);
        }

        if (studentDTO.getCourses() != null) {
            Set<Course> courses = studentDTO.getCourses().stream()
                    .map(courseDTO -> {
                        Course course = new Course();
                        course.setIdCourse(courseDTO.getIdCourse());
                        course.setName(courseDTO.getName());
                        return course;
                    }).collect(Collectors.toSet());
            student.setCourseStudent(courses);
        }

        return student;
    }

}
