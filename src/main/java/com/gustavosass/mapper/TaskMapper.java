package com.gustavosass.mapper;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gustavosass.dto.TaskCreateDTO;
import com.gustavosass.dto.TaskDTO;
import com.gustavosass.dto.UserDTO;
import com.gustavosass.model.Task;
import com.gustavosass.model.User;

@Component
public class TaskMapper {
	
	@Autowired
	private UserMapper userMapper;
	
	public TaskDTO toDto(Task task) {
		Long id = task.getId();
		String title = task.getTitle();
		String description = task.getDescription();
		Date dueDate = task.getDueDate();
		Set<UserDTO> users = task.getUsers().stream().map(userMapper::toDto).collect(Collectors.toSet());
		return new TaskDTO(id, title, description, dueDate, users);
	}
	
	public Task toTask(TaskCreateDTO taskCreateDTO) {
		String title = taskCreateDTO.getTitle();
		String description = taskCreateDTO.getDescription();
		Date dueDate = taskCreateDTO.getDueDate();
		Set<User> users = taskCreateDTO.getUsers().stream().map(userMapper::toUser).collect(Collectors.toSet());
		return new Task(title, description, dueDate, users);
	}
	
	public Task toTask(TaskDTO taskDto) {
		Long id = taskDto.getId();
		String title = taskDto.getTitle();
		String description = taskDto.getDescription();
		Date dueDate = taskDto.getDueDate();
		Set<User> users = taskDto.getUsers().stream().map(userMapper::toUser).collect(Collectors.toSet());
		return new Task(id, title, description, dueDate, users);
	}
}
