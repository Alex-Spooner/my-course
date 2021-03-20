package com.alexspooner.petspring.service;

import com.alexspooner.petspring.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course findById(int id);

    List<Course> findByName(String name);

    Course add(Course course);

    Course update(Course course);

    void deleteById(int id);
}
