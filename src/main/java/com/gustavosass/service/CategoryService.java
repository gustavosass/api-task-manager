package com.gustavosass.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavosass.model.Category;


@Service
public interface CategoryService {
	
	Category findByName(String name);
		
	List<Category> findAll();
	
	Category findById(Long id);
		
	Category create(Category category);
	
	Category update(Long id, Category category);
	
	void delete(Long id);
}
