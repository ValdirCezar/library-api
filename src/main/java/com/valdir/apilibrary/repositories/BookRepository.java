package com.valdir.apilibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valdir.apilibrary.domain.Book;
import com.valdir.apilibrary.domain.Category;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findByCategories(Category category);
}
