package com.alexspooner.petspring.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@Table("COURSES")
public class CourseEntity {
    @Id
    private Integer id;
    private String name;
}
