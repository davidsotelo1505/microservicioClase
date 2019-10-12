package com.api.clase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.clase.model.Students;
import com.api.clase.service.IStudentsService;



@RestController
public class StudentsController {
	
	@Autowired(required = true)
	@Qualifier("itemServiceRestTemplate")
	private IStudentsService studentsService;
	
	@GetMapping("/list")
	public List<Students> getAll(){
		return studentsService.getAll();
	}
	
	@GetMapping("/{id}/{quantity}")
	public Students getById(@PathVariable Long id, @PathVariable Integer quantity) {
		return studentsService.findById(id, quantity);
	}
}
