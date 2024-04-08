package kea.exersice.harrypotter003.DTO;

import kea.exersice.harrypotter003.model.House;

import java.time.LocalDate;

public class StudentResponseDTO {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate DateOfBirth;
    private String house;
    private boolean prefect;
    private int enrollementYear;
    private int schoolYear;
    private int graduationYear;
    private boolean graduated;

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

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public String getFullName(){
        if(hasMiddlename() && getMiddleName() != null){
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }

    }
    public boolean hasMiddlename(){
        return middleName != null;
    }



}