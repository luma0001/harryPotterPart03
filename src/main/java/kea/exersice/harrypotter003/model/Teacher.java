package kea.exersice.harrypotter003.model;

import jakarta.persistence.*;
import kea.exersice.harrypotter003.model.EmpType;

import java.time.LocalDate;


//https://petlatkea.notion.site/Hogwarts-part-3-REST-API-627c448970884b2db1845995ec9b4570

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firsName;
    private String middleName;
    private String lastName;
    private LocalDate DateOfBirth;
    //@OneToOne
    @ManyToOne
    @JoinColumn(name = "house")
    private House house;
    private EmpType employmentType;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;



    public Teacher() {
    }

    public Teacher(String firsName, String middleName, String lastName, LocalDate dateOfBirth, House house, EmpType employmentType, LocalDate employmentStart, LocalDate employmentEnd) {
        this.firsName = firsName;
        this.middleName = middleName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.house = house;
        this.employmentType = employmentType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public EmpType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmpType employmentType) {
        this.employmentType = employmentType;
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart) {
        this.employmentStart = employmentStart;
    }

    public LocalDate getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(LocalDate employmentEnd) {
        this.employmentEnd = employmentEnd;
    }
}
