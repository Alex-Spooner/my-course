package com.alexspooner.petspring.service;

import com.alexspooner.petspring.model.Course;
import com.alexspooner.petspring.repository.dao.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

@Component
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return stream(spliteratorUnknownSize(courseRepository.findAll().iterator(), Spliterator.ORDERED), false)
                .map(courseEntity -> new Course(courseEntity.getId(), courseEntity.getName()))
                .collect(Collectors.toList());
    }

}
