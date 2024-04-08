package kea.exersice.harrypotter003.model;
import jakarta.persistence.*;
import kea.exersice.harrypotter003.model.HogwartsPerson;


import java.time.LocalDate;
import java.util.Arrays;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String middleName;
    private String lastName;

    private LocalDate DateOfBirth;
    //@OneToOne
    // This change should resolve the issue you were facing with duplicate entry errors when saving multiple students with the same house. Now, multiple students can reference the same house without violating any constraints.
    @ManyToOne
    @JoinColumn(name = "house")
    private House house;
    private boolean prefect;
    private int enrollementYear;
    private int graduationYear;
    private boolean graduated;

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public int getEnrollementYear() {
        return enrollementYear;
    }

    public void setEnrollementYear(int enrollementYear) {
        this.enrollementYear = enrollementYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public Student(String firstName, String middleName, String lastName, LocalDate DateOfBirth, House house, boolean prefect, int enrollementYear, int graduationYear, boolean graduated) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.DateOfBirth = DateOfBirth;
        this.house = house;
        this.prefect = prefect;
        this.enrollementYear = enrollementYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }


//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", middleName='" + middleName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", DateOfBirth=" + DateOfBirth +
//                ", house='" + (house != null ? house.getName() : "N/A") + '\'' +
//                ", prefect=" + prefect +
//                ", enrollementYear=" + enrollementYear +
//                ", graduationYear=" + graduationYear +
//                ", graduated=" + graduated +
//                '}';
//    }

}


