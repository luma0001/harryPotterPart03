package kea.exersice.harrypotter003.controller;


import kea.exersice.harrypotter003.model.Student;
//import kea.exersice.harrypotter003.repository.StudentRepository;
import kea.exersice.harrypotter003.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// VI SKAL LAVE EN NY TING - student service!  Lav alle vores repositories til service.
// så skal vi importere alle vores metoder fra et nyt sted...
// SÅ SKAL VI HAVE EN student-service classe

// PUT - hvis id ikke er der: SKAL DEN FEJLE? ELLER BLIVE EN POST - med det ID man giver...
//... alle Studet skal nu ændres til StudentDTO!

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }



    @GetMapping("{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable int id ) {
        //Optional<Student> student = studentRepository.findById(id);
        return ResponseEntity.of(studentRepository.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        Optional<Student> deleteStudent = studentRepository.findById(id);
        studentRepository.deleteById(id);
        return ResponseEntity.of(deleteStudent);
        //return deleteStudent.orElse();
    }

}