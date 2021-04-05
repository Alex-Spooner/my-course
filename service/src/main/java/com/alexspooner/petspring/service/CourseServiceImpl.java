package com.alexspooner.petspring.service;

import com.alexspooner.petspring.service.mapper.CourseMapper;
import com.alexspooner.petspring.model.Course;
import com.alexspooner.petspring.repository.dao.CourseRepository;
import com.alexspooner.petspring.repository.entities.CourseEntity;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public List<Course> findAll() {
        return CourseMapper.getCoursesFromEntities(courseRepository.findAll().iterator());
    }

    @Override
    @Transactional
    public List<Course> findByName(String name) {
        return CourseMapper.getCoursesFromEntities(courseRepository.findByName(name).iterator());
    }

    @Override
    @Transactional
    public Course findById(int id) {
        return CourseMapper.getCourseFromEntity(findByIdChecked(id));
    }

    @Override
    @Transactional
    public Course add(Course course) {
        var resultCourse = courseRepository.save(new CourseEntity(null, course.getName()));
        return CourseMapper.getCourseFromEntity(resultCourse);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        findByIdChecked(course.getId());
        var resultCourse = courseRepository.save(new CourseEntity(course.getId(), course.getName()));
        return CourseMapper.getCourseFromEntity(resultCourse);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    private CourseEntity findByIdChecked(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no course for the id " + id));
    }

}
