package com.alexspooner.petspring.repository.dao;

import com.alexspooner.petspring.repository.entities.CourseEntity;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CourseRepositoryTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testGetAllCourses() {
        Iterable<CourseEntity> allCourseEntities = courseRepository.findAll();
        assertThat(IterableUtils.size(allCourseEntities)).isEqualTo(3);
    }

}
