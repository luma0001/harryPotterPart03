package kea.exersice.harrypotter003.controller;

import jdk.javadoc.doclet.Reporter;
import kea.exersice.harrypotter003.model.Student;
import kea.exersice.harrypotter003.model.Teacher;
import kea.exersice.harrypotter003.repository.CourseRepository;
import kea.exersice.harrypotter003.model.Course;
import kea.exersice.harrypotter003.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;

    private CourseController(CourseRepository courseRepository) {this.courseRepository = courseRepository; }


    // Get all Courses
     @GetMapping
     public List<Course> getAll(){return courseRepository.findAll(); }

    // Get Course by id
    @GetMapping("{id}")
    public ResponseEntity<Course> getOneCourse(@PathVariable int id){
        return ResponseEntity.of(courseRepository.findById(id));
    }

    // get teacher from course
     @GetMapping("{id}/teacher")
     public ResponseEntity<Teacher> getCourseTeacher(@PathVariable int id){
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()){
            Course course = courseOptional.get();
            Teacher teacher = course.getTeacher();
            if(teacher != null){
                return ResponseEntity.ok(teacher);
            } else {
                return ResponseEntity.noContent().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
     };

    // Course get students
@GetMapping("{id}/students")
public ResponseEntity<List<Student>> getCourseStudents(@PathVariable int id){
    Optional<Course> courseOptional = courseRepository.findById(id);
    if (courseOptional.isPresent()) {
        Course course = courseOptional.get();
        List<Student> students = course.getStudents();
        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.notFound().build(); // No students associated with this course
        }
    } else {
        return ResponseEntity.notFound().build(); // Course not found
    }
}

    // Post a new Course
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Course createCourse(@RequestBody Course course) {return courseRepository.save(course);}


    //  Update a new Course...
 @PutMapping("{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course){
        course.setId(id);
        return  courseRepository.save(course);
 }

 // Delete a Course
     @DeleteMapping("{id}")
     public ResponseEntity<Course> deleteCourse(@PathVariable int id){
     Optional<Course> deleteCourse = courseRepository.findById(id);
     courseRepository.deleteById(id);
     return ResponseEntity.of(deleteCourse);
 }

}
