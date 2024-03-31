package kea.exersice.harrypotter003.service;


// en optional er ligesom en liste der kan være tom eller have 1 student. Vi vil altid returne noget - er listen tom, kan vi gøre noget...

import kea.exersice.harrypotter003.DTO.StudentDTO;
import kea.exersice.harrypotter003.model.Student;
import kea.exersice.harrypotter003.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

// contstructor dependency?
   private final StudentRepository studentRepository;

   private StudentService(StudentRepository studentRepository){
       this.studentRepository = studentRepository;
   }

   // find service for the @GetMapping
    public List<Student> findAll(){
        return studentRepository.findAll();
    }


    public Optional<Student> findById(int id){
        return studentRepository.findById(id);
    }

    public Student save(Student student){
      return studentRepository.save(student);
    }


    public Optional<Student> updateIfExists(int id, Student student){
       if(studentRepository.findById(id).isPresent()){
           student.setId(id);
           return Optional.of(student);
       } else {
           return Optional.empty();
       }
    }

    public Optional<Student> deleteById(int id)
    {
        Optional<Student> existingStudent = studentRepository.findById(id);
       studentRepository.deleteById(id);
       return existingStudent;
    }

    //// Lav en toDTO metode i service!
    public StudentDTO toDTO(Student entity){
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setDateOfBirth(entity.getDateOfBirth());
//    dto.setHouse(entity.getHouse().getName());
        dto.setPrefect(entity.isPrefect());
        dto.setEnrollementYear(dto.getEnrollementYear());
        dto.setGraduationYear(dto.getEnrollementYear());

        return dto;
    }


    // THIS TING??
//    public List <StudentDTO> getAllAsDTO(){
//       return StreamSupport.steam(findAll().spliterator(),false).map(this::toDTO).collectors(Collectors.toList());
//    }

//    public studentRepsonseDTO save(studentREquestDTO student){
//        return toDTO(studentRespoistory.save(toEntity.save());
//    }

//    private Student toEntity(StudentRequestDTO dto){
//        Student entity = new Student();
//        entity.setFirstName(student.getFirstName());
//    }
//    public List<Student> getAll() {
//        return studentRepository.findAll().stream().map(this::toDTO);
//    }
//
//    // en optional er en liste, der kun kan indeholde 1 ting. - så hvis der er noget inde i listen så kald det der er iden som metode?
//    //... det er en meget kort if else - Chris' ord.
//public Optional<StudentDTO>findById(int id){
//    return studentRepository.findById(id).map(this::DTO).toList();
//}





//// i VOERES find all I studentService-- skal vi tilføje findAll().stream().map(this::toDTO);
//// :: er for at lave en "refferance" og ikke et "kald"

//// flip det med constructor entity - flip
//    public Student toEntity(StudentDTO student){
//        Student entity = new Student();
//        entity.setFirstName(dto.getFirstName());
//        entity.setMiddleName(dto.getMiddleName());
//        entity.setLastName(dto.getLastName());
//        entity.setDateOfBirth(dto.getDateOfBirth());
////    entity.setHouse(dto.getHouse().getName());
//        entity.setHouse(dto.getHouse());
//        entity.setId(dto.getId());
//        entity.setPrefect(dto.isPrefect());
//        entity.setEnrollementYear(dto.getEnrollementYear());
//        entity.setGraduationYear(dto.getEnrollementYear());
//
//        Optional<House> house = houseRepository.findById(dto.getHouse());
//        house.ifPresent(entity::setHouse); // hvis det er pressent, så kald den metode, på det objekt.
//
//        return entity;
//}
}
