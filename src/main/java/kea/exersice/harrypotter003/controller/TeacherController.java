package kea.exersice.harrypotter003.controller;

import kea.exersice.harrypotter003.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kea.exersice.harrypotter003.model.Teacher;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {


    //Cannot invoke "kea.exersice.harrypotter003.repository.TeacherRepository.save(Object)" because "this.teacherRepository" is null
        @Autowired
        private TeacherRepository teacherRepository;

        private TeacherController(TeacherRepository teacherRepository){
            this.teacherRepository = teacherRepository;
        }

        @GetMapping()
    public List<Teacher> getAll(){
            return teacherRepository.findAll();
        }

//        @GetMapping("{id}")
//        public ResponseEntity<Teacher> getTeacher(@PathVariable int id){
//            return ResponseEntity.of(teacherRepository.findById(id));
//        }



}
