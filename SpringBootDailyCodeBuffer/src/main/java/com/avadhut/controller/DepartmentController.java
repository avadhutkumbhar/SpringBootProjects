package com.avadhut.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avadhut.entity.Department;
import com.avadhut.error.DepartmentNotFoundException;
import com.avadhut.service.DepartmentService;

/**
 * @author AVADHUT KUMBHAR
 *
 */
@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	//changes in department controller to check the file is reflected for commit in git bash or not
	@PostMapping("saveDepartment")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		log.info("Inside DepartmentController==>>saveDepartment() method.");
		return departmentService.saveDepartment(department);
	}

	@PostMapping("saveListOfDepartment")
	public String saveListOfDepartment(@RequestBody List<Department> departments) {
		log.info("Inside DepartmentController==>>saveListOfDepartment() method.");
		return  departmentService.saveListOfDepartment(departments);
	}

	@GetMapping("getAllDepartments")
	public List<Department> getAllDepartments() {
		log.info("Inside DepartmentController==>>getAllDepartments() method.");
		return departmentService.getAllDepartments();
	}

	@GetMapping("getDepartmentById/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return new ResponseEntity<Department>(departmentService.getDepartmentById(departmentId), HttpStatus.FOUND);
//			return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartmentById(departmentId));
		
	}

	@DeleteMapping("deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable("id") Long departmentId) {
		return departmentService.deleteDepartment(departmentId);
	}

	@PutMapping("updateDepartment/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}

	@GetMapping("getDepartmentByName/{dName}")
	public Department getDepartmentByName(@PathVariable String dName) {
		return departmentService.findByDepartmentName(dName);
	}

	@GetMapping("departmentById/{id}")
	public Department departmentById(@PathVariable Long id) {
		return departmentService.findByDepartmentId(id);
	}

	/**
	 * Method to demonstrate @Query Annotation to use native SQL
	 * 
	 * @param name
	 * @return Department
	 */
	@GetMapping("getDemartmentByNameUsingNativeQuery/{name}")
	public Department getDemartmentByNameUsingNativeQuery(@PathVariable String name) {
		return departmentService.getDemartmentByNameUsingNativeQuery(name);
	}
}
