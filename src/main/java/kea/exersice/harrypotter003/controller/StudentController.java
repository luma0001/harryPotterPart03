package kea.exersice.harrypotter003.controller;


import jakarta.persistence.Entity;
import kea.exersice.harrypotter003.model.Student;
//import kea.exersice.harrypotter003.repository.StudentRepository;
import kea.exersice.harrypotter003.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




// VI SKAL LAVE EN NY TING - student service!  Lav alle vores repositories til service.
// så skal vi importere alle vores metoder fra et nyt sted...
// SÅ SKAL VI HAVE EN student-service classe

// PUT - hvis id ikke er der: SKAL DEN FEJLE? ELLER BLIVE EN POST - med det ID man giver...
//


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

  @PostMapping
  public Student createStudent(@RequestBody Student student){
    return studentRepository.save(student);
  }

//@GetMapping("students/'${id}'")
//        public Student getStudent(@RequestBody Student student){
//          return studentRepository.save(student);
//         }

    // --- Chat GPT solution
//    @GetMapping("/students/{id}")
//    public ResponseEntity<Student> getById(@PathVariable Integer id) {
//        Optional<Student> studentOptional = studentRepository.findById(id);
//        return studentOptional.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }



//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.DateOfBirth = DateOfBirth;
//        this.house = house;
//        this.prefect = prefect;
//        this.enrollementYear = enrollementYear;
//        this.graduationYear = graduationYear;
//        this.graduated = graduated;



    @GetMapping("/{id}")
    public ResponseEntity<Student> getPerson(@PathVariable int id){
        Optional<Student> student = studentRepository.findById(id);
        return ResponseEntity.of(student);
    }


    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updatePerson(@PathVariable int id, @RequestBody Student student){
        Optional<Student> original = studentRepository.findById(id);
        // return ResponseEntity.of(studentService.updateIfExists(id, student));
        if(original.isPresent()){
            Student originalStudent = original.get();

            originalStudent.setFirstName(student.getFirstName());
            originalStudent.setMiddleName(student.getMiddleName());
            originalStudent.setLastName(student.getLastName());
            originalStudent.setDateOfBirth(student.getDateOfBirth());
            originalStudent.setHouse(student.getHouse());
            originalStudent.setPrefect(student.isPrefect());
            originalStudent.setEnrollementYear(student.getEnrollementYear());
            originalStudent.setGraduationYear(student.getGraduationYear());
            originalStudent.setGraduated(student.isGraduated());

            Student updatePerson = studentRepository.save(originalStudent);
            return ResponseEntity.ok().body(updatePerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @DeleteMapping("/persons/{id}")
//    public ResponseEntity<Person> deletePerson(@PathVariable int id){
//        Optional<Person> person = personRepository.findById(id);
//        personRepository.deleteById(id);
//        return ResponseEntity.of(person);
//    }





}
