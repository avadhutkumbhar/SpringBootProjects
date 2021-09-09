package com.avadhut.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.avadhut.entity.Department;
import com.avadhut.error.DepartmentNotFoundException;
import com.avadhut.repository.DepartmentRepository;
import com.avadhut.service.DepartmentService;

/**
 * @author AVADHUT KUMBHAR
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public Department saveDepartment(Department department) {
		return repository.save(department);
	}

	public List<Department> getAllDepartments() {
		return repository.findAll();
	}

	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException  {
		Optional<Department> optional  = 
				repository.findById(departmentId);
		if (!optional.isPresent()) {
			String msg = "Department Not available for the Department ID: "+departmentId;
			throw new DepartmentNotFoundException(msg);
		} else {
			return optional.get();
		}
	}

	public String deleteDepartment(Long departmentId) {
		repository.deleteById(departmentId);
		return "Delete Successfull!!!";
	}

	/**
	 * method to update the department by ID
	 */
	public Department updateDepartment(Long departmentId, Department department) {
		Department dbDepartment = repository.findById(departmentId).get();

		if (null != department) {

			if (!ObjectUtils.isEmpty(department.getDepartmentName()) && Objects.nonNull(department.getDepartmentName()))
				dbDepartment.setDepartmentName(department.getDepartmentName());

			if (!ObjectUtils.isEmpty(department.getDepartmentCode()) && Objects.nonNull(department.getDepartmentCode()))
				dbDepartment.setDepartmentCode(department.getDepartmentCode());

			if (!ObjectUtils.isEmpty(department.getDepartmentAddress())
					&& Objects.nonNull(department.getDepartmentAddress()))
				dbDepartment.setDepartmentAddress(department.getDepartmentAddress());

			repository.save(dbDepartment);
		}
		return dbDepartment;
	}

	public String saveListOfDepartment(List<Department> departments) {

		repository.saveAll(departments);

		return "Successful!!";
	}

	public Department findByDepartmentName(String dName) {
		return repository.findByDepartmentName(dName);
	}

	public Department findByDepartmentId(Long id) {
		return repository.findByDepartmentId(id);
	}

	public Department getDemartmentByNameUsingNativeQuery(String name) {
		return repository.getDemartmentByNameUsingNativeQuery(name);
	}
}
