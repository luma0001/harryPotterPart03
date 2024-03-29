package kea.exersice.harrypotter003.app;

import kea.exersice.harrypotter003.model.Course;
import kea.exersice.harrypotter003.model.House;
import kea.exersice.harrypotter003.model.Student;
import kea.exersice.harrypotter003.model.Teacher;
import kea.exersice.harrypotter003.repository.CourseRepository;
import kea.exersice.harrypotter003.repository.StudentRepository;
import kea.exersice.harrypotter003.repository.TeacherRepository;
import kea.exersice.harrypotter003.repository.HouseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static kea.exersice.harrypotter003.model.EmpType.PROFESSOR;

@Component
public class InitData implements CommandLineRunner {

    private  TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private HouseRepository houseRepository;


    public InitData(StudentRepository studentRepository, TeacherRepository teacherRepository, CourseRepository courseRepository, HouseRepository houseRepository){
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.houseRepository = houseRepository;
    }



    public void run(String... arg){
        System.out.println("Init data running");

        House raveclaw = new House("Ravenclaw", "Rowena Ravenclaw", List.of(new String[]{"Blue", "Bronze"}));
        houseRepository.save(raveclaw);
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", List.of(new String[]{"Scarlet", "Gold"}));
        houseRepository.save(gryffindor);
        House slytherin = new House("Slytherin", "Salazar Slytherin", List.of(new String[]{"Green", "Silver"}));
        houseRepository.save(slytherin);
        House huffelpuff = new House("Hufflepuff", "Helga Hufflepuff", List.of(new String[]{"Yellow", "Black"}));
        houseRepository.save(huffelpuff);

        Student student1 = new Student("Harry", "James", "Potter", LocalDate.parse("1980-07-31"), gryffindor, false, 1991, 1998, true);
        studentRepository.save(student1);
        Student student2 = new Student("Hermione", "Jean", "Granger", LocalDate.parse("1979-09-19"), gryffindor, true, 1991, 1998, true);
        studentRepository.save(student2);
        Student student3 = new Student("Ron", null, "Weasley", LocalDate.parse("1980-03-01"), gryffindor, false, 1991, 1998, true);
        studentRepository.save(student3);
            Student student6 = new Student("Neville", "Frank", "Longbottom", LocalDate.parse("1980-07-30"), gryffindor, false, 1991, 1998, true);
        studentRepository.save(student6);
        Student student7 = new Student("Ginny", null, "Weasley", LocalDate.parse("1981-08-11"), gryffindor, false, 1991, 1998, true);
        studentRepository.save(student7);
        Student student8 = new Student("Fred", null, "Weasley", LocalDate.parse("1978-04-01"), gryffindor, false, 1991, 1998, true);
        studentRepository.save(student8);
        Student student9 = new Student("George", null, "Weasley", LocalDate.parse("1978-04-01"), gryffindor, false, 1991, 1998, true);
        studentRepository.save(student9);
                Student student12 = new Student("Seamus", null, "Finnigan", LocalDate.parse("1980-10-01"), gryffindor, false, 1991, 1998, true);
        studentRepository.save(student12);
        Student student4 = new Student("Draco", null, "Malfoy", LocalDate.parse("1980-06-05"), slytherin, true, 1991, 1998, true);
        studentRepository.save(student4);
        Student student5 = new Student("Luna", null, "Lovegood", LocalDate.parse("1981-02-13"), raveclaw, false, 1991, 1998, true);
        studentRepository.save(student5);
        Student student11 = new Student("Cho", null, "Chang", LocalDate.parse("1979-09-01"), raveclaw, false, 1991, 1998, true);
        studentRepository.save(student11);
        Student student10 = new Student("Cedric", null, "Diggory", LocalDate.parse("1977-09-01"), huffelpuff, true, 1991, 1995, true);
        studentRepository.save(student10);

        Teacher teacher1= new Teacher("Pomona", "", "Sprout", LocalDate.parse("1941-05-15"), huffelpuff, PROFESSOR, LocalDate.of(1974, 9, 1), LocalDate.of(2001, 6, 30));
        teacherRepository.save(teacher1);


        Course course1 = new Course("Botanics", 1991, false, teacher1, List.of(new Student[]{student1, student2, student3}));
        courseRepository.save(course1);

    }
}
