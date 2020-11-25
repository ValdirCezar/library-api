package com.valdir.apilibrary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.apilibrary.domain.Book;
import com.valdir.apilibrary.domain.Category;
import com.valdir.apilibrary.dtos.BookDTO;
import com.valdir.apilibrary.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryService categoryService;

	public Book insert(Integer id, BookDTO obj) {
		Category category = categoryService.findById(id);
		Book newObj = new Book(null, obj.getTitle());
		newObj.getCategories().add(category);
		category.getBooks().add(newObj);
		return repository.save(newObj);
	}

	public List<Book> findAllByCategory(Integer id) {
		return repository.findByCategories(categoryService.findById(id));
	}
}
