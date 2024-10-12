package com.gustavosass.dto;

import java.util.Date;
import java.util.Set;

public class TaskDTO {
	
	private long id;
	private String title;
	private String description;
	private Date dueDate;
	private Set<UserDTO> users;
	
	public TaskDTO() {}
	
	public TaskDTO(long id, String title, String description, Date dueDate, Set<UserDTO> users) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.users = users;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}
