package com.valdir.apilibrary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.apilibrary.domain.Category;
import com.valdir.apilibrary.dtos.CategoryDTO;
import com.valdir.apilibrary.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public CategoryDTO fromDTO(Category obj) {
		return new CategoryDTO(obj);
	}

}
