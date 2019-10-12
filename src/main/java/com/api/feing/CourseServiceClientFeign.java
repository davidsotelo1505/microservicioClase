package com.api.feing;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.unilibre.invoice.model.Product;

@FeignClient(name = "course-service")
public interface CourseServiceClientFeign {
	
	@GetMapping("/list")
	public List<Course> getList();
	
	@GetMapping("/{id}")
	public Course getById(@PathVariable Long id);
}
