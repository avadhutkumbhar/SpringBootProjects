package com.avadhut.spring.data.jpa.tutorial;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.avadhut.spring.data.jpa.tutorial.entity.Course;
import com.avadhut.spring.data.jpa.tutorial.entity.Teacher;
import com.avadhut.spring.data.jpa.tutorial.repository.TeacherRepository;

@SpringBootTest
public class TeacherReposotoryTest {

	@Autowired
	private TeacherRepository repository;
	
	
	@Test
	public void addTeacherData() {
		Course course = Course.builder()
				.title("DBA")
				.credit(100)
				.build();
	
		List<Course> courses = Arrays.asList(
				new Course(1, "DBA", 100, null, null)
				);
				
		
		Teacher teacher = Teacher.builder()
				.firstName("Mr. Pradip")
				.lastName("Patil")
				.cources(courses)
				.build();
		
		/**
		 * code to get the pagination
		 */
//		PageRequest page  = PageRequest.of(0, 2);
	
		Pageable page  = PageRequest.of(0, 2, Sort.by("ava").descending());
//		
//		Pageable sortedByPriceDesc = 
//				  PageRequest.of(0, 3, Sort.by("price").descending());
		repository.findAll(page).getContent().forEach(a->System.out.println(a));;
		
		
		repository.save(teacher);
	}
}
