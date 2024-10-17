package com.gustavosass.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavosass.model.Category;
import com.gustavosass.model.Task;
import com.gustavosass.repository.TaskRepository;
import com.gustavosass.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task findById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public List<Task> findTasksByUserId(Long id) {
		return taskRepository.findTasksByUserId(id);
	}

	@Override
	public Task create(Task task) {
		List<Long> usersIds = task.getUsers().stream().map(n -> n.getId()).collect(Collectors.toList());

		if (!userServiceImpl.existsUsersById(usersIds)) {
			throw new NoSuchElementException();
		}

		Category category = categoryServiceImpl.findByName(task.getCategory().getName());
		task.setCategory(category);
		return taskRepository.save(task);

	}

	@Override
	public Task update(Long id, Task task) {
		taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException());

		// Valida se existe todos os usuários no banco.
		List<Long> usersIds = task.getUsers().stream().map(n -> n.getId()).collect(Collectors.toList());
		if (!userServiceImpl.existsUsersById(usersIds)) {
			throw new NoSuchElementException();
		}

		// Retorna o objeto da categoria encontrado pelo nome, desconsiderando o ID informado.
		Category category = categoryServiceImpl.findByName(task.getCategory().getName());
		task.setCategory(category);
		return taskRepository.save(task);

	}

	@Override
	public void delete(Long id) {
		taskRepository.deleteById(id);
	}

}
