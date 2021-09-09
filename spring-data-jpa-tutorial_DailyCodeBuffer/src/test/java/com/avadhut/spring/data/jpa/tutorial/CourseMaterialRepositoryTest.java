package com.avadhut.spring.data.jpa.tutorial;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.avadhut.spring.data.jpa.tutorial.entity.Course;
import com.avadhut.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.avadhut.spring.data.jpa.tutorial.entity.Student;
import com.avadhut.spring.data.jpa.tutorial.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseRepository;
	
	//insert course data
	@Test
	public void saveCourse() {
		Course c = Course.builder()
				.title("Spring Data JPA")
				.credit(100)
				.build();
		
		
		CourseMaterial courseMaterial =  CourseMaterial.builder()
				.url("google")
				.course(c)
				.build();
		courseRepository.save(courseMaterial);
	}//saveCourse
	
	@Test
	public void updateCourseMaterial() {
		int count =	courseRepository.updateCourseMaterial(1, "https://docs.spring.io/spring-data/jpa/docs/");
	}
	
	@Test
	public void listOfCourseMaterials() {
		List<CourseMaterial> couseMaterialsList = courseRepository.findAll();
		for (CourseMaterial courseMaterial : couseMaterialsList) {
			System.out.println(courseMaterial);
		}
	}
	
	public void saveCourseWithStudentAndTeacher() {
		Course course = Course.builder()
				.title("AI")
				.credit(12)
				.courseMaterial(null)
				.build();
		
		Student student = Student.builder()
				.firstName("abhishek")
				.lastName("sing")
				.emailId("abhi@gmail.com").build();
		
		course.addStudents(student);
		
//		courseRepository.save(course);
	}
}
