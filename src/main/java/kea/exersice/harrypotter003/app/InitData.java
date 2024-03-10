package kea.exersice.harrypotter003.app;


import kea.exersice.harrypotter003.model.EmpType;
import kea.exersice.harrypotter003.model.House;
import kea.exersice.harrypotter003.model.Student;
import kea.exersice.harrypotter003.model.Teacher;
import kea.exersice.harrypotter003.model.EmpType;
//import kea.exersice.harrypotter003.repository.StudentRepository;
import kea.exersice.harrypotter003.repository.StudentRepository;
import kea.exersice.harrypotter003.repository.TeacherRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    private  TeacherRepository teacherRepository;


    House GRYFFINDOR = new House("Gryffindor", "Godric Gryffindor", new String[]{"Scarlet", "Gold"});
    House SLYTHERIN = new House("Slytherin", "Salazar Slytherin", new String[]{"Green", "Silver"});
    House RAVENCLAW = new House("Ravenclaw", "Rowena Ravenclaw", new String[]{"Blue", "Bronze"});
    House HUFFLEPUFF = new House("Hufflepuff", "Helga Hufflepuff", new String[]{"Yellow", "Black"});

    public InitData(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public void run(String... arg){
        System.out.println("Init data running");

        Student student1 = new Student("Harry", "James", "Potter", LocalDate.parse("1980-07-31"), "Gryffindor", false, 1991, 1998, true);
        Student student2 = new Student("Hermione", "Jean", "Granger", LocalDate.parse("1979-09-19"), "Gryffindor", true, 1991, 1998, true);
        Student student3 = new Student("Ron", null, "Weasley", LocalDate.parse("1980-03-01"), "Gryffindor", false, 1991, 1998, true);
        Student student4 = new Student("Draco", null, "Malfoy", LocalDate.parse("1980-06-05"), "Slytherin", true, 1991, 1998, true);
        Student student5 = new Student("Luna", null, "Lovegood", LocalDate.parse("1981-02-13"), "Ravenclaw", false, 1991, 1998, true);
        Student student6 = new Student("Neville", "Frank", "Longbottom", LocalDate.parse("1980-07-30"), "Gryffindor", false, 1991, 1998, true);
        Student student7 = new Student("Ginny", null, "Weasley", LocalDate.parse("1981-08-11"), "Gryffindor", false, 1991, 1998, true);
        Student student8 = new Student("Fred", null, "Weasley", LocalDate.parse("1978-04-01"), "Gryffindor", false, 1991, 1998, true);
        Student student9 = new Student("George", null, "Weasley", LocalDate.parse("1978-04-01"), "Gryffindor", false, 1991, 1998, true);
        Student student10 = new Student("Cedric", null, "Diggory", LocalDate.parse("1977-09-01"), "Hufflepuff", true, 1991, 1995, true);
        Student student11 = new Student("Cho", null, "Chang", LocalDate.parse("1979-09-01"), "Ravenclaw", false, 1991, 1998, true);
        Student student12 = new Student("Seamus", null, "Finnigan", LocalDate.parse("1980-10-01"), "Gryffindor", false, 1991, 1998, true);

        Teacher teacher1= new Teacher("Pomona", "", "Sprout", LocalDate.parse("1941-05-15"), "HUFFLEPUFF", "PROFESSOR", LocalDate.of(1974, 9, 1), LocalDate.of(2001, 6, 30));

        System.out.println(student1);
        System.out.println(student2);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);
        studentRepository.save(student8);
        studentRepository.save(student9);
        studentRepository.save(student10);
        studentRepository.save(student11);
        studentRepository.save(student12);
        teacherRepository.save(teacher1);







    }
}
