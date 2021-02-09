package com.alexspooner.petspring.repository.course;

import com.alexspooner.petspring.repository.entities.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
}
