package com.gustavosass.mapper;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gustavosass.dto.task.CreateTaskDTO;
import com.gustavosass.dto.task.TaskDTO;
import com.gustavosass.dto.task.category.CategoryDTO;
import com.gustavosass.dto.user.UserDTO;
import com.gustavosass.enums.Priority;
import com.gustavosass.model.Category;
import com.gustavosass.model.Task;
import com.gustavosass.model.User;

@Component
public class TaskMapper {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public TaskDTO toDto(Task task) {
		Long id = task.getId();
		String title = task.getTitle();
		String description = task.getDescription();
		Date dueDate = task.getDueDate();
		Set<UserDTO> users = task.getUsers().stream().map(userMapper::toDto).collect(Collectors.toSet());
		CategoryDTO category = categoryMapper.toDto(task.getCategory());
		Priority priority = task.getPriority();
		return new TaskDTO(id, title, description, dueDate, users, category, priority);
	}
	
	public Task toTask(CreateTaskDTO taskCreateDTO) {
		String title = taskCreateDTO.getTitle();
		String description = taskCreateDTO.getDescription();
		Date dueDate = taskCreateDTO.getDueDate();
		Set<User> users = taskCreateDTO.getUsers().stream().map(userMapper::toUser).collect(Collectors.toSet());
		Category category = categoryMapper.toCategory(taskCreateDTO.getCategory());
		Priority priority = taskCreateDTO.getPriority();
		return new Task(title, description, dueDate, users, category, priority);
	}
	
	public Task toTask(TaskDTO taskDto) {
		Long id = taskDto.getId();
		String title = taskDto.getTitle();
		String description = taskDto.getDescription();
		Date dueDate = taskDto.getDueDate();
		Set<User> users = taskDto.getUsers().stream().map(userMapper::toUser).collect(Collectors.toSet());
		Category category = categoryMapper.toCategory(taskDto.getCategory());
		Priority priority = taskDto.getPriority();
		return new Task(id, title, description, dueDate, users, category, priority);
	}
}
