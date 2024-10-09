package com.gustavosass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavosass.model.Task;
import com.gustavosass.service.impl.TaskServiceImpl;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		return ResponseEntity.ok(taskServiceImpl.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id){
		return ResponseEntity.ok(taskServiceImpl.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody Task task){
		Task taskCreated = taskServiceImpl.create(task);
		return ResponseEntity.ok(taskCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task){
		Task taskUpdated = taskServiceImpl.update(id, task);
		return ResponseEntity.ok(taskUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		taskServiceImpl.delete(id);
		return ResponseEntity.ok().build();
	}
}
