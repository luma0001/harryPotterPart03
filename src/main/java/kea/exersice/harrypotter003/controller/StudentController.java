package kea.exersice.harrypotter003.controller;


import kea.exersice.harrypotter003.DTO.StudentRequestDTO;
import kea.exersice.harrypotter003.DTO.StudentResponseDTO;
import kea.exersice.harrypotter003.model.Student;
import kea.exersice.harrypotter003.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    private StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAll() {
        var students = this.studentService.findAll();
        if(students != null){
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable int id ) {
        var student = this.studentService.findById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentResponseDTO>  createStudent(@RequestBody StudentRequestDTO student){
        StudentResponseDTO savedStudent = studentService.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PatchMapping("{id}")
    public ResponseEntity<StudentResponseDTO> patchStudent (@PathVariable int id, @RequestBody StudentRequestDTO updatedStudent){
        Optional<StudentResponseDTO> patchedStudent = studentService.patchStudent(id, updatedStudent);
        return patchedStudent.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Flere patches... som kan ændre prefect og schoolyear...
    // slår man graduatedYear skal graduated blive true...

    @PutMapping("{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable int id, @RequestBody StudentRequestDTO student) {
        return ResponseEntity.of(studentService.updateIfExists(id, student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StudentResponseDTO> deleteStudent(@PathVariable int id) {
        return ResponseEntity.of(studentService.deleteById(id));
    }

}