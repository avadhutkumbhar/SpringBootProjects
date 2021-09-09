package com.avadhut.spring.data.jpa.tutorial;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.avadhut.spring.data.jpa.tutorial.entity.Course;
import com.avadhut.spring.data.jpa.tutorial.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository repository;

	@Test
	public void printAllCourses() {
		List<Course> list = repository.findAll();
		System.out.println(list);
	}
}
