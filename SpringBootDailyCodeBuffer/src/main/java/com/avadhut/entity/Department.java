package com.avadhut.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author AVADHUT KUMBHAR
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	/**
	 * Check the different types of validations provided by javax.validation.
	 * https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html
	 * 
	 * We are using spring boot starter validation build on top of hibernate validations
	 */
	@NotBlank(message="Please add Department Name.") 
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	
}
  