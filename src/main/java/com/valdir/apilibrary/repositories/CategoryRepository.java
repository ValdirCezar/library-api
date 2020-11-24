package com.valdir.apilibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valdir.apilibrary.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
