package com.alexspooner.petspring.mapper;

import com.alexspooner.petspring.model.Course;
import com.alexspooner.petspring.repository.entities.CourseEntity;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

public class CourseMapper {
    private static final Function<CourseEntity, Course> COURSE_MAPPING_FUNCTION = courseEntity
            -> new Course(courseEntity.getId(), courseEntity.getName());

    public static Course getCourseFromEntity(CourseEntity entity) {
        return COURSE_MAPPING_FUNCTION.apply(entity);
    }

    public static List<Course> getCoursesFromEntities(Iterator<CourseEntity> courseEntityIterator) {
        return stream(spliteratorUnknownSize(courseEntityIterator, Spliterator.ORDERED), false)
                .map(COURSE_MAPPING_FUNCTION)
                .collect(Collectors.toList());
    }
}
