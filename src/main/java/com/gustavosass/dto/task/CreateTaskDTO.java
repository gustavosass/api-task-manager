package com.gustavosass.dto.task;

import java.util.Date;
import java.util.Set;

import com.gustavosass.dto.task.category.CategoryDTO;
import com.gustavosass.dto.user.UserDTO;
import com.gustavosass.enums.Priority;
import com.gustavosass.model.Category;

public class CreateTaskDTO {
	private String title;
	private String description;
	private Date dueDate;
	private Set<UserDTO> users;
	private CategoryDTO category;
	private Priority priority;

	public CreateTaskDTO() {
	}

	public CreateTaskDTO(String title, String description, Date dueDate, Set<UserDTO> users, CategoryDTO category,
			Priority priority) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.users = users;
		this.category = category;
		this.priority = priority;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Set<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

}
