package com.avadhut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author AVADHUT KUMBHAR
 *
 */
@RestController
public class HelloController {

	@GetMapping("helloSpringBoot")
	public String helloMethod() {
		return "Welcome to the spring boot application!!!";
	}
	
	@RequestMapping(value="welcome",method = RequestMethod.GET,produces="application/json")
	public String welcome() {
		return "Welcome to the Spring Boot Applicaton";
	}
	
}   
