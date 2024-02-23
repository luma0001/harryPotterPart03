package kea.exersice.harrypotter003.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kea.exersice.harrypotter003.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}