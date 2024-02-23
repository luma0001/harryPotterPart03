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
    private String house;
    private boolean prefect;
    private int enrollementYear;
    private int graduationYear;
    private boolean graduated;

    public Student() {

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

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
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

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String firstName, String middleName, String lastName, LocalDate DateOfBirth, String house, boolean prefect, int enrollementYear, int graduationYear, boolean graduated) {
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", house='" + house + '\'' +
                ", prefect=" + prefect +
                ", enrollementYear=" + enrollementYear +
                ", graduationYear=" + graduationYear +
                ", graduated=" + graduated +
                '}';
    }
}


