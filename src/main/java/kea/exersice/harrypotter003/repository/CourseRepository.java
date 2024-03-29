package kea.exersice.harrypotter003.repository;

import kea.exersice.harrypotter003.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
