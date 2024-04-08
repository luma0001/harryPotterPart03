package kea.exersice.harrypotter003.service;

import kea.exersice.harrypotter003.DTO.StudentRequestDTO;
import kea.exersice.harrypotter003.model.House;
import kea.exersice.harrypotter003.model.Student;
import kea.exersice.harrypotter003.repository.HouseRepository;
import kea.exersice.harrypotter003.repository.StudentRepository;
import kea.exersice.harrypotter003.DTO.StudentResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

// contstructor dependency?
   private final StudentRepository studentRepository;

    private final HouseRepository houseRepository;

    private StudentService(StudentRepository studentRepository, HouseRepository houseRepository){
       this.studentRepository = studentRepository;
       this.houseRepository = houseRepository;
   }

   public  List<StudentResponseDTO> findAll(){
        return studentRepository.findAll().stream().map(this::toDTO).toList();
   }

   public Optional<StudentResponseDTO> findById(int id){
        return studentRepository.findById(id).map(this::toDTO);
   }

public StudentResponseDTO save(StudentRequestDTO student){
        return toDTO(studentRepository.save(toEntity(student)));
}


public Optional<StudentResponseDTO> patchStudent(int id, StudentRequestDTO studentDTO){
        return studentRepository.findById(id).map(exsitingStudent -> {
            updateEntity(exsitingStudent, studentDTO);
            Student updatedStudent = studentRepository.save(exsitingStudent);
            return Optional.of(toDTO(updatedStudent));
        }).orElse(Optional.empty());
}


public Optional <StudentResponseDTO> updateIfExists (int id, StudentRequestDTO student){
        if(studentRepository.existsById(id)){
            Student entity = toEntity(student);
            entity.setId(id);
            return Optional.of(toDTO(studentRepository.save(entity)));
        } return  Optional.empty();
}

    public Optional<StudentResponseDTO> deleteById(int id){
        Optional<StudentResponseDTO> existingStudent = findById(id);
        studentRepository.deleteById(id);
        return existingStudent;
    }


    // NB: StudentResponseDTO er der der var DTO i undervisningstimen.
    // Funktionen tager en entity og returnere en (Response)DTO som returneres.
    public StudentResponseDTO toDTO(Student entity){
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setHouse(entity.getHouse().getName());
        dto.setPrefect(entity.isPrefect());
        dto.setEnrollementYear(entity.getEnrollementYear());
        dto.setGraduationYear(entity.getGraduationYear());
        dto.setGraduated(entity.isGraduated());


        return dto;
    }

    // Funktionen tager et Request DTO og genere en entity på baggrund af den, som den returnere.
    public Student toEntity(StudentRequestDTO requestDto){
        Student entity = new Student();
        entity.setFirstName(requestDto.firstName());
        entity.setMiddleName(requestDto.middleName());
        entity.setLastName(requestDto.lastName());
        entity.setDateOfBirth(requestDto.dateOfBirth());
        entity.setPrefect(requestDto.prefect());
        entity.setEnrollementYear(requestDto.enrollementYear());
        entity.setGraduationYear(requestDto.graduationYear());
        entity.setGraduated(requestDto.graduated());

        Optional<House> house = houseRepository.findById(requestDto.house());
        house.ifPresent(entity::setHouse); // hvis det er pressent, så kald den metode, på det objekt.

        return entity;
    }

    // Funktionen tager et ResponseDTO og laver en entity på baggrund af det. Returnere denne entity.
    public Student convertToRequestDTO(StudentResponseDTO responseDTO){
        Student entity = new Student();
        entity.setId(responseDTO.getId());
        entity.setFirstName(responseDTO.getFirstName());
        entity.setMiddleName(responseDTO.getMiddleName());
        entity.setLastName(responseDTO.getLastName());
        entity.setDateOfBirth(responseDTO.getDateOfBirth());
        entity.setPrefect(responseDTO.isPrefect());
        entity.setEnrollementYear(responseDTO.getEnrollementYear());
        entity.setGraduationYear(responseDTO.getGraduationYear());
        entity.setGraduated(responseDTO.isGraduated());

        Optional<House> house = houseRepository.findById(responseDTO.getHouse());
        house.ifPresent(entity::setHouse);

        return entity;
    }

    // Denne funktion lader til at lave en ny entity påbaggrund af en RequestDTO, men kun for de attributter som ikke er null.
    //@Transactional // Vi vil gerne have udtates som transactional - men så crasher den!
    public void updateEntity(Student entity, StudentRequestDTO dto){
        if (dto.firstName() != null) entity.setFirstName(dto.firstName());
        if (dto.middleName() != null) entity.setMiddleName(dto.middleName());
        if (dto.lastName() != null) entity.setLastName(dto.lastName());
        if (dto.dateOfBirth() != null) entity.setDateOfBirth(dto.dateOfBirth());
        if (dto.prefect() != null) entity.setPrefect(dto.prefect());
        if (dto.enrollementYear() != null) entity.setEnrollementYear(dto.enrollementYear());
        if (dto.graduationYear() != null) entity.setGraduationYear(dto.graduationYear());
        if (dto.graduated() != null) entity.setGraduated(dto.graduated());
        if (dto.house() != null){
            Optional<House> house = houseRepository.findById(dto.house());
            house.ifPresent(entity::setHouse);
        }

    }


/*
    ----------------- Student Service Uden DTO -------------------------------------------------------------
  Fidusen er at servicelaget "snakker" med resporitoylaget - istedet for controlleren.
  */


//   // find service for the @GetMapping
//    public List<Student> findAll(){
//        return studentRepository.findAll();
//    }
//
//
//    public Optional<Student> findById(int id){
//        return studentRepository.findById(id);
//    }
//
//    public Student save(Student student){
//      return studentRepository.save(student);
//    }
//
//
//    public Optional<Student> updateIfExists(int id, Student student){
//       if(studentRepository.findById(id).isPresent()){
//           student.setId(id);
//           return Optional.of(student);
//       } else {
//           return Optional.empty();
//       }
//    }
//
//    public Optional<Student> deleteById(int id)
//    {
//        Optional<Student> existingStudent = studentRepository.findById(id);
//       studentRepository.deleteById(id);
//       return existingStudent;
//    }
    // ------------------------------------------------------------------------------------------------



    //------------- NOTER FRA UNDERVISNINGS DAGEN-----------------------------------------------------------
//    public List <StudentDTO> getAllAsDTO(){
//       return StreamSupport.steam(findAll().spliterator(),false).map(this::toDTO).collectors(Collectors.toList());
//    }
//
//    public studentRepsonseDTO save(studentRequestDTO student){
//        return toDTO(studentRespoistory.save(toEntity.save());
//    }

//    private Student toEntity(StudentRequestDTO dto){
//        Student entity = new Student();
//        entity.setFirstName(student.getFirstName());
//    }
//    public List<Student> getAll() {
//        return studentRepository.findAll().stream().map(this::toDTO);
//    }
//    // en optional er en liste, der kun kan indeholde 1 ting. - så hvis der er noget inde i listen så kald det der er iden som metode?
//    //... det er en meget kort if else - Chris' ord.
//public Optional<StudentDTO>findById(int id){
//    return studentRepository.findById(id).map(this::DTO).toList();
//}

//// i VOERES find all I studentService-- skal vi tilføje findAll().stream().map(this::toDTO);
//// :: er for at lave en "refferance" og ikke et "kald"



}
