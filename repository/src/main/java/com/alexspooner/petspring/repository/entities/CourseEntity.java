package com.alexspooner.petspring.repository.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("COURSES")
public class CourseEntity {
    @Id
    private Integer id;
    private String name;
}
