package com.alexspooner.petspring.repository.dao;

import com.alexspooner.petspring.repository.entities.CourseEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {

    @Query("SELECT c.id, c.name FROM courses c WHERE c.name = :name")
    List<CourseEntity> findByName(@Param("name") String name);
}
