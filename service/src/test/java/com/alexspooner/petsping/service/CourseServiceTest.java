package com.alexspooner.petsping.service;

import com.alexspooner.petspring.model.Course;
import com.alexspooner.petspring.repository.dao.CourseRepository;
import com.alexspooner.petspring.repository.entities.CourseEntity;
import com.alexspooner.petspring.service.CourseService;
import com.alexspooner.petspring.service.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CourseServiceTest {

    private CourseRepository courseRepository;

    private CourseService courseService;

    @BeforeEach
    public void setUp() {
        courseRepository = mock(CourseRepository.class);
        courseService = new CourseServiceImpl(courseRepository);
    }

    @Test
    public void testGetAllCourses() {
        int courseId = 1;
        when(courseRepository.findAll()).thenReturn(singletonList(new CourseEntity(courseId, "Java Course")));

        List<Course> resultCourse = courseService.findAll();

        assertThat(resultCourse.size()).isEqualTo(1);
        assertThat(resultCourse.get(0).getId()).isEqualTo(courseId);
    }

}
