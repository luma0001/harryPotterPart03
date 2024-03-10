package kea.exersice.harrypotter003.repository;

import kea.exersice.harrypotter003.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import kea.exersice.harrypotter003.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}