/**
 * 
 */
package com.avadhut.spring.data.jpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.avadhut.spring.data.jpa.tutorial.entity.Course;
import com.avadhut.spring.data.jpa.tutorial.entity.CourseMaterial;

/**
 * @author Avadhut
 * @version 1.0
 * @since 17-07-2021
 */
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Integer> {
	
	 

	@Modifying
	@Transactional
	@Query(value="update tbl_course_material set url= ?1 where course_material_id = ?2",nativeQuery=true)
	public int updateCourseMaterial(int id,String url);


}
