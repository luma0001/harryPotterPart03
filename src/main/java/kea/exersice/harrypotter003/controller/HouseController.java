package kea.exersice.harrypotter003.controller;

import kea.exersice.harrypotter003.model.House;
import kea.exersice.harrypotter003.model.Teacher;
import kea.exersice.harrypotter003.repository.HouseRepository;
import kea.exersice.harrypotter003.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/house")
    public class HouseController {


        private HouseRepository houseRepository;

        @Autowired
        private HouseController(HouseRepository houseRepository){
            this.houseRepository = houseRepository;
        }
        @GetMapping()
        public List<House> getAll(){
            return houseRepository.findAll();
        }

        @GetMapping("{id}")
        public ResponseEntity<House> getTeacher(@PathVariable int id){
            return ResponseEntity.of(houseRepository.findById(id));
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public House createTeacher(@RequestBody House house) {
            return houseRepository.save(house);
        }



    }
