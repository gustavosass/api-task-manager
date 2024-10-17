package com.gustavosass.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavosass.model.Task;

@Service
public interface TaskService {
		
	List<Task> findTasksByUserId(Long id);
	
	List<Task> findAll();
	
	Task findById(Long id);
		
	Task create(Task task);
	
	Task update(Long id, Task task);
	
	void delete(Long id);
}
