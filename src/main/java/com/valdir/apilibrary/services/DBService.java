package com.valdir.apilibrary.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.apilibrary.domain.Book;
import com.valdir.apilibrary.domain.Category;
import com.valdir.apilibrary.repositories.BookRepository;
import com.valdir.apilibrary.repositories.CategoryRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public void instantiateTestDataBase() {
		
		Category c1 = new Category(null, "Computing");
		Category c2 = new Category(null, "Personal development");
		
		Book b1 = new Book(null, "Clean Code", "Description from Clean Code");
		Book b2 = new Book(null, "Code Complete", "Description from Code Complete");
		Book b3 = new Book(null, "Desingn Patterns", "Description from Desingn Patterns");
		Book b4 = new Book(null, "How to make friends and influence people", "Description from How to make friends and influence people");
		Book b5 = new Book(null, "The Power of Now", "Description from The Power of Now");
		
		c1.getBooks().addAll(Arrays.asList(b1, b2, b3));
		c2.getBooks().addAll(Arrays.asList(b4, b5));
		
		b1.getCategories().addAll(Arrays.asList(c1));
		b2.getCategories().addAll(Arrays.asList(c1));
		b3.getCategories().addAll(Arrays.asList(c1));
		b4.getCategories().addAll(Arrays.asList(c2));
		b5.getCategories().addAll(Arrays.asList(c2));
		
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));
	}

}
