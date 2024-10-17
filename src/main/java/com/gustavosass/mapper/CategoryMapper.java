package com.gustavosass.mapper;

import org.springframework.stereotype.Component;

import com.gustavosass.dto.task.category.CategoryDTO;
import com.gustavosass.model.Category;

@Component
public class CategoryMapper {
	public CategoryDTO toDto(Category category) {
		long id = category.getId();
		String name = category.getName();
		return new CategoryDTO(id, name);
	}

	public Category toCategory(CategoryDTO categoryDto) {
		long id = categoryDto.getId();
		String name = categoryDto.getName();
		return new Category(id, name);
	}
}
