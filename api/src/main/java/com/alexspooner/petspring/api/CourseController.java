package com.alexspooner.petspring.api;

import com.alexspooner.petspring.model.Course;
import com.alexspooner.petspring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public List<Course> getAll() {
        return courseService.findAll();
    }

    @GetMapping(path = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getByName(@RequestParam String name) {
        return courseService.findByName(name);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Course addCourse(@RequestBody Course course) {
        return courseService.add(course);
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        return courseService.update(course);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
    }

}
