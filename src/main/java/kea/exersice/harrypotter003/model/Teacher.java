package kea.exersice.harrypotter003.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;


//https://petlatkea.notion.site/Hogwarts-part-3-REST-API-627c448970884b2db1845995ec9b4570

@Entity
public class Teacher {
    @Id
    private Long id;
    private String firsName;
    private String middleName;
    private String lastName;
    private LocalDate DateOfBirth;
    private String house;
    private String employmentType;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;



    public Teacher() {
    }

    public Teacher(String firsName, String middleName, String lastName, LocalDate dateOfBirth, String house, String employmentType, LocalDate employmentStart, LocalDate empploymentEnd) {
        this.firsName = firsName;
        this.middleName = middleName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.house = house;
        this.employmentType = String.valueOf(employmentType);
        this.employmentStart = employmentStart;
        this.employmentEnd = empploymentEnd;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
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

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart) {
        this.employmentStart = employmentStart;
    }

    public LocalDate getEmpploymentEnd() {
        return employmentEnd;
    }

    public void setEmpploymentEnd(LocalDate empploymentEnd) {
        this.employmentEnd = empploymentEnd;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firsName='" + firsName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", house='" + house + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", employmentStart=" + employmentStart +
                ", empploymentEnd=" + employmentEnd +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
