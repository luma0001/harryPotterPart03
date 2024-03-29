package kea.exersice.harrypotter003.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Course {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Subject;
private int schoolYear;
private boolean current;

 @ManyToOne
private Teacher teacher;

// private String students;
@ManyToMany
private List<Student> students = new ArrayList<>();

//private Student[] students;

    public Course(String subject, int schoolYear, boolean current, Teacher teacher, List<Student> students) {
        this.Subject = subject;
        this.schoolYear = schoolYear;
        this.current = current;
        this.teacher = teacher;
        this.students = students;
    }

    // With add students
    public Course(String subject, int schoolYear, boolean current, Teacher teacher, Student student) {
        this.Subject = subject;
        this.schoolYear = schoolYear;
        this.current = current;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.students.add(student);
    }

    public Course() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public  List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
