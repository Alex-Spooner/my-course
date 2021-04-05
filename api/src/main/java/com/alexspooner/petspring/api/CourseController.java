package com.alexspooner.petspring.api;

import com.alexspooner.petspring.model.Course;
import com.alexspooner.petspring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping(path = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(courseService.findByName(name));
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> getById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.add(course));
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        return ResponseEntity.ok(courseService.update(course));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
