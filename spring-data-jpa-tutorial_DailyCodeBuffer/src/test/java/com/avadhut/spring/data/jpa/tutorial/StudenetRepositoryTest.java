package com.avadhut.spring.data.jpa.tutorial;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.Builder;

import com.avadhut.spring.data.jpa.tutorial.entity.Guardian;
import com.avadhut.spring.data.jpa.tutorial.entity.Student;
import com.avadhut.spring.data.jpa.tutorial.repository.StudentRepository;

@SpringBootTest
public class StudenetRepositoryTest {
	
	@Autowired
	private StudentRepository repository;

	@Test
	public void getAllData() {
		List<Student> studentList =  repository.findAll();
//		studentList.forEach(System.out::println);
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
	
	
	// Test Method to used to save the student object with guardian
	
	@Test
	public void saveStudentWithGuardian() {
		Guardian g = Guardian.builder().name("Reshma").email("reshma@gmail.com").mobile("7840908585").build();

		Student s = Student.builder().firstName("ganesh").lastName("patil").emailId("ganesh@gmail.com").guardian(g)
				.build();

		repository.save(s);

	}//saveStudentWithGuardian
	
	@Test
	public void findRecordByName() {
		List<Student> list = repository.findByFirstName("avadhut");
		list.forEach(System.out::println);
		
	}
	
	@Test
	public void getStudentByEmailId() {
		Student student =repository.getStudentByEmailId("avadhut@gmauil");
		System.out.println(student);
	}
	
	
	@Test
	public void getStudentFirstNameByEmailId() {
	String s  =repository.getStudentFirstNameByEmailId("avadhut@gmauil");
		System.out.println("Student Name by mail ID: "+s);
	}
	
	@Test
	public void printgetStudentByEmailAddressNative() {
		Student s = repository.getStudentByEmailAddressNative("avadhut@gmauil");
		System.out.println(s);
	}
	
	@Test
	public void getStudentNameNamedParamQuery() {
		Student s = repository.getStudentNameNamedParamQuery("avadhut@gmauil");
		System.out.println(s);
	}
	
	@Test
	public void updateStudentEmailAddress() {
		int count = repository.updateStudentEmailAddress("test.email.update@gmail.com", "ganesh");
		if(count>0)
			System.out.println("Record Updated Successfully!!!");
		else
			System.out.println("Record insertion faild!!");
	}
}

