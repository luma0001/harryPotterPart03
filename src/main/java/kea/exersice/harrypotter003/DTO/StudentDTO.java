package kea.exersice.harrypotter003.DTO;

import java.time.LocalDate;



/*
Den bedste DTO er lavet a primitives... int og booleans
Den skal være immutable - lige som Stings og LocalDate. Vi kan ikke ændre den. De er primitive-nok!

De inteties der laves skal laves om til DTO og omvendt!
- Man kunne også finde på at lave en MAPPER metode. Der er mange måder at ændre på det!

S i solid, minder meget om Seperation Of Conserns. De skal ske meget lokalt når vi ændre noget.


*/

public class StudentDTO {
    private int id;

    private boolean headBotOrGirl;

    private String firstName;
    private String middleName;
    private String lastName;

    private LocalDate DateOfBirth;
    private String house;
    private boolean prefect;
    private int enrollementYear;
    private int graduationYear;
    private boolean graduated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHeadBotOrGirl() {
        return headBotOrGirl;
    }

    public void setHeadBotOrGirl(boolean headBotOrGirl) {
        this.headBotOrGirl = headBotOrGirl;
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

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }
}
