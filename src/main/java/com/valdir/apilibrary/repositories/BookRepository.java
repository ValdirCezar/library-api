package com.valdir.apilibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valdir.apilibrary.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
}
