package com.api.clase.service;

import java.util.List;

import com.api.clase.model.Students;

public interface IStudentsService {
	public List<Students> getAll();
	public Students findById(Long id, Integer quantity);
}
