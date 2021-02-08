package com.example.demo.repository;

import com.example.demo.repository.model.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
}
