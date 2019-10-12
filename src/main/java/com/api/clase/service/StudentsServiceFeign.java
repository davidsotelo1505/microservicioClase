package com.api.clase.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.clase.model.Course;
import com.api.clase.model.Students;
import com.api.feing.CourseServiceClientFeign;


@Service("studentsServiceFeign")
public class StudentsServiceFeign implements IStudentsService{

	@Autowired
	private CourseServiceClientFeign courseServiceClientFeign; 
	
	@Override
	public List<Students> getAll() {
		List<Course> course = courseServiceClientFeign.getList();
		return course.stream().map(prod -> new Students(prod, 1)).collect(Collectors.toList());
	}

	@Override
	public Students findById(Long id, Integer quantity) {
		return new Students(courseServiceClientFeign.getById(id), quantity);
	}

}
