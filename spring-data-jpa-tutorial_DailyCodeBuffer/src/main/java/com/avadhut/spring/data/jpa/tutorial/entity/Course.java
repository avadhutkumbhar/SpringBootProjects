
package com.avadhut.spring.data.jpa.tutorial.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tbl_course")
public class Course {
	
	@Id
	@SequenceGenerator(name="course_sequence",sequenceName= "course_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="course_sequence")
	private long courseId;
	private String title;
	private int credit;
	
	@OneToOne(mappedBy="course")
	private CourseMaterial courseMaterial;
	
	@ManyToMany
	@JoinTable(name="student_course_map",
		joinColumns = @JoinColumn(name="course_id",referencedColumnName="courseId")
		,inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName="studentId")
			)
	private List<Student> students;
	
	public void addStudents(Student student) {
		if (student==null) {
			new ArrayList<Object>();
		}else {
			students.add(student);
		}
	}
}
