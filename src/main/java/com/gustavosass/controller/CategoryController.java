package com.gustavosass.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavosass.dto.task.category.CategoryDTO;
import com.gustavosass.mapper.CategoryMapper;
import com.gustavosass.model.Category;
import com.gustavosass.service.impl.CategoryServiceImpl;

import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> listCategoryDto = categoryServiceImpl.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());
		return ResponseEntity.ok(listCategoryDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
		CategoryDTO categoryDto = categoryMapper.toDto(categoryServiceImpl.findById(id));
		return ResponseEntity.ok(categoryDto);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDTO> create(@RequestBody @Valid CategoryDTO categoryDto){
		Category category = categoryMapper.toCategory(categoryDto);
		Category createdCategory = categoryServiceImpl.create(category);
		return ResponseEntity.ok(categoryMapper.toDto(createdCategory));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody @Valid CategoryDTO categoryDto){
		Category category = categoryMapper.toCategory(categoryDto);
		Category updatedCategory = categoryServiceImpl.update(id, category);
		return ResponseEntity.ok(categoryMapper.toDto(updatedCategory));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		categoryServiceImpl.delete(id);
		return ResponseEntity.ok().build();
	}
}
