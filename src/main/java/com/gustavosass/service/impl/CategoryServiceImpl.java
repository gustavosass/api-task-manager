package com.gustavosass.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavosass.model.Category;
import com.gustavosass.repository.CategoryRepository;
import com.gustavosass.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category findByName(String name) {
		return categoryRepository.findByName(name).orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Long id, Category category) {
		Category categoryExists = categoryRepository.findById(id).orElseThrow(NoSuchElementException::new);
		categoryExists.setName(category.getName());
		return categoryRepository.save(categoryExists);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

}
