package com.avadhut.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avadhut.spring.data.jpa.tutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByFirstName(String name);

	//JPQL
	@Query("select s from Student s where s.emailId = ?1")
	public Student getStudentByEmailId(String email);
	
	//JPQL
	//get the first name by email id
	@Query("select s.firstName from Student s where s.emailId = ?1")
	public String getStudentFirstNameByEmailId(String email);
	
	//Native Query
	@Query(value = "select * from tbl_student where email_address = ?",nativeQuery = true)
	public Student getStudentByEmailAddressNative(String email);
	
	//Named Parameteres
	@Query(value = "select * from tbl_student where email_address = :emailId",nativeQuery = true)
	public Student getStudentNameNamedParamQuery(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional
	@Query(value="update tbl_student set email_address = ?1 where first_name = ?2",nativeQuery = true)
	public int updateStudentEmailAddress(String email,String name);
	
}
