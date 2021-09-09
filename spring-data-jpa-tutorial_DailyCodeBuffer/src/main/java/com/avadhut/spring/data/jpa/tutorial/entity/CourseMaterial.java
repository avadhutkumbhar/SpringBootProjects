package com.avadhut.spring.data.jpa.tutorial.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude="course")
@Table(name="tbl_course_material")
public class CourseMaterial {

	@Id
	@SequenceGenerator(name="course_material_sequence",sequenceName="course_material_sequence",allocationSize=1)
	@GeneratedValue(generator="course_material_sequence",strategy=GenerationType.SEQUENCE)
	private int courseMaterialId;
	private String url;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",referencedColumnName="courseId")
	private Course course;
}
