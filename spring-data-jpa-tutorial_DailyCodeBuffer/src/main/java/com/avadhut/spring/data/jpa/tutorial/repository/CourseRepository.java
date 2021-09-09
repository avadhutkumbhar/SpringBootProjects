package com.avadhut.spring.data.jpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avadhut.spring.data.jpa.tutorial.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
