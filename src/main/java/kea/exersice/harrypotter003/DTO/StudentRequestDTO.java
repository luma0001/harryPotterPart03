package kea.exersice.harrypotter003.DTO;
import jakarta.persistence.*;
import kea.exersice.harrypotter003.DTO.StudentDTO;
import kea.exersice.harrypotter003.model.House;

import java.time.LocalDate;


public record StudentRequestDTO(
    String firstName,
    String middleName,
    String lastName,
    String name,
    Integer graduationYear,
    Boolean graduated,
    LocalDate dateOfBirth,
    Boolean prefect,
    Integer enrollementYear,
    String house
) {

    public StudentRequestDTO{

        // Auto-forkortet. Er graduation year null, så er graduated false, ellers er  det true.
       if(graduationYear != null){
           graduated = true;
       } else {
           graduated = false;
       }


        if(name != null){
            String[] parts = name.split(" ");
            firstName = parts[0];
            lastName = parts[parts.length-1];
            if (parts.length > 2){
                middleName = parts[1];
            }
        }
    }
}
