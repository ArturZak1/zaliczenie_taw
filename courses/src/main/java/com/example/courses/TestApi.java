package com.example.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;




@RestController
@RequestMapping("api")
public class TestApi {

    private final List<Course> courses = new ArrayList<>();
    private Long idCounter = 1L;

    @PostMapping(value = "courses",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addCourse(@RequestBody Course course) {
        course.setId(idCounter++);
        courses.add(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "courses",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourses(@RequestParam(required = false) Boolean egzamin,
                                   @RequestParam(required = false) Integer numerSali) {
        if (egzamin != null && numerSali != null) {
            return courses.stream()
                    .filter(course -> course.isExam() == egzamin && course.getRoomNumber() == numerSali)
                    .collect(Collectors.toList());
        } else if (egzamin != null) {
            return courses.stream()
                    .filter(course -> course.isExam() == egzamin)
                    .collect(Collectors.toList());
        } else if (numerSali != null) {
            return courses.stream()
                    .filter(course -> course.getRoomNumber() == numerSali)
                    .collect(Collectors.toList());
        } else {
            return courses;
        }
    }




    @GetMapping(value = "courses/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = findCourseById(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "courses/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        Course course = findCourseById(id);
        if (course != null) {
            courses.remove(course);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping (value = "courses")
    public ResponseEntity<Void> deleteAllCourses() {
        courses.clear();
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "courses/exam",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getCoursesWithExam() {
        List<Course> coursesWithExam = courses.stream()
                .filter(Course::isExam)
                .collect(Collectors.toList());
        return ResponseEntity.ok(coursesWithExam);
    }

    @GetMapping(value = "courses/room/{roomNumber}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getCoursesByRoomNumber(@PathVariable int roomNumber) {
        List<Course> coursesByRoomNumber = courses.stream()
                .filter(course -> course.getRoomNumber() == roomNumber)
                .collect(Collectors.toList());
        return ResponseEntity.ok(coursesByRoomNumber);
    }

    private Course findCourseById(Long id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
