package com.avadhut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avadhut.entity.Department;
/**
 * @author AVADHUT KUMBHAR
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	public Department findByDepartmentName(String dName);
	public Department findByDepartmentId(Long id);

	@Query(value="SELECT * FROM DEPARTMENT DEPARTMENT  WHERE DEPARTMENT_NAME LIKE  %?1%",nativeQuery=true)
	public Department getDemartmentByNameUsingNativeQuery(String name);
}
