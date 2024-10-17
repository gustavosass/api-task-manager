package com.gustavosass.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavosass.model.Category;

import jakarta.persistence.Entity;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	Optional<Category> findByName(String name);
	
}
