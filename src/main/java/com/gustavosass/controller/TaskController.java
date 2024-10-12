package com.gustavosass.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.gustavosass.dto.TaskCreateDTO;
import com.gustavosass.dto.TaskDTO;
import com.gustavosass.mapper.TaskMapper;
import com.gustavosass.model.Task;
import com.gustavosass.service.impl.TaskServiceImpl;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> findAll(){
		List<TaskDTO> listTaskDto = taskServiceImpl.findAll().stream().map(taskMapper::toDto).collect(Collectors.toList()); 
		return ResponseEntity.ok(listTaskDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id){
		TaskDTO taskDto = taskMapper.toDto(taskServiceImpl.findById(id));
		return ResponseEntity.ok(taskDto);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<TaskDTO>> findTasksByUserId(@PathVariable Long id){
		List<TaskDTO> listTaskDto = taskServiceImpl.findTasksByUserId(id).stream().map(taskMapper::toDto).collect(Collectors.toList());
		return ResponseEntity.ok(listTaskDto);
	}
	
	@PostMapping
	public ResponseEntity<TaskDTO> create(@RequestBody TaskCreateDTO taskCreateDto){
		Task task = taskMapper.toTask(taskCreateDto);
		Task taskCreated = taskServiceImpl.create(task);
		TaskDTO taskDto = taskMapper.toDto(taskCreated);
		return ResponseEntity.ok(taskDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDto){
		Task task = taskMapper.toTask(taskDto);
		Task taskUpdated = taskServiceImpl.update(id, task);
		return ResponseEntity.ok(taskMapper.toDto(taskUpdated));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		taskServiceImpl.delete(id);
		return ResponseEntity.ok().build();
	}
}
