package com.example.springboot.controller;

import com.example.springboot.exception.InternalServerErrorApplicationException;
import com.example.springboot.exception.BadRequestApplicationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot!";
	}

	@GetMapping("/input")
	public String returnInput(@RequestParam(value = "name" , defaultValue = "default-name") String name, @RequestParam(value = "id", required=false) Integer id) {

		// check bad request
		if (name == "null" || name == "" || id < 0 || id == null) {
			throw new BadRequestApplicationException("Invalid input ...");
		} else  {
			return "name: "+ name +" id:"+id;
		}

	}

	// ExceptionHandler usage within the controller class
/*
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleIllegalArgumentException(IllegalArgumentException e){
		return e.getMessage();
	}
*/

	@GetMapping("/runtime-err")
	public void simulateRuntimeErr() {
		throw new InternalServerErrorApplicationException("Simulation - Internal server error thrown");
	}

}
