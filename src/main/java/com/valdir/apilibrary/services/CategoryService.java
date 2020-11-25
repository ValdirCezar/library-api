package com.valdir.apilibrary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.apilibrary.domain.Category;
import com.valdir.apilibrary.dtos.CategoryDTO;
import com.valdir.apilibrary.repositories.CategoryRepository;
import com.valdir.apilibrary.services.exceptions.DataIntegrityViolationException;

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

	public CategoryDTO create(CategoryDTO obj) {
		Category newObj = new Category(null, obj.getName());
		repository.save(newObj);
		obj = fromDTO(newObj);
		return obj;
	}

	public Category updateAll(CategoryDTO objDto) {
		Category newObj = new Category(objDto.getId(), objDto.getName());
		return repository.save(newObj);
	}

	public void deleteById(Integer id) {
		repository.findById(id);
		
		try {
			repository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(
					"Object has associations and cannot be deleted! Id: " + id + ", Type: " + Category.class.getName());
		}
	}

	public CategoryDTO fromDTO(Category obj) {
		return new CategoryDTO(obj);
	}

}
