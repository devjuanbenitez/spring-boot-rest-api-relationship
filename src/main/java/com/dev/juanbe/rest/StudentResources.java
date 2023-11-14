package com.dev.juanbe.rest;

import com.dev.juanbe.model.StudentDTO;
import com.dev.juanbe.services.StudentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentResources {
private final StudentService studentService;
    public StudentResources(final StudentService studentService) {

        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudent() {
        return ResponseEntity.ok(studentService.finAll());
    }
    @GetMapping("/{dni}")
    public ResponseEntity<StudentDTO> getStudentByDni(
            @PathVariable(name = "dni") final Integer dni) {
        return ResponseEntity.ok(studentService.getByDni(dni));
    }
    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createRecomendaciones(
            @RequestBody @Valid final StudentDTO studentDTO) {
        final Integer createdIdStudent = studentService.create(studentDTO);
        return new ResponseEntity<>(createdIdStudent, HttpStatus.CREATED);
    }
    @PutMapping("/{idStudent}")
    public ResponseEntity<Void> updateStudent(
            @PathVariable(name = "idStudent") final Integer idStudent,
            @RequestBody @Valid final StudentDTO studentDTO) {
        studentService.update(idStudent, studentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idStudent}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable(name = "idStudent") final Integer idStudent) {
        studentService.delete(idStudent);
        return ResponseEntity.noContent().build();
    }
}
