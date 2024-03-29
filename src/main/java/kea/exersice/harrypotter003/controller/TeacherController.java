package kea.exersice.harrypotter003.controller;

import kea.exersice.harrypotter003.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kea.exersice.harrypotter003.model.Teacher;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {


        private TeacherRepository teacherRepository;

        @Autowired
        private TeacherController(TeacherRepository teacherRepository){
            this.teacherRepository = teacherRepository;
        }
        @GetMapping()
        public List<Teacher> getAll(){
            return teacherRepository.findAll();
        }

        @GetMapping("{id}")
        public ResponseEntity<Teacher> getTeacher(@PathVariable int id){
            return ResponseEntity.of(teacherRepository.findById(id));
        }

        // DO NOT WORK!
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }


    @PutMapping("{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable int id) {
        Optional<Teacher> deleteTeacher = teacherRepository.findById(id);
        teacherRepository.deleteById(id);
        return ResponseEntity.of(deleteTeacher);
    }



}
