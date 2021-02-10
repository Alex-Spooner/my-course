package com.alexspooner.petspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CourseApplicationTests {

	@Autowired
	private ApplicationContext appContext;

	@Test
	void contextLoads() {
		assertTrue(appContext.containsBean("courseApplication"));
		assertTrue(appContext.containsBean("courseController"));
	}

}
