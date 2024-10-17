package com.gustavosass.model;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.Cascade;

import com.gustavosass.enums.Priority;
import com.gustavosass.enums.StatusTask;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Date dueDate;
	@ManyToMany(cascade = CascadeType.DETACH)
	private Set<User> users;
	@ManyToOne(cascade = CascadeType.DETACH)
	private Category category;
    @Enumerated(EnumType.STRING)
	private Priority priority;
    @Enumerated(EnumType.STRING)
	private StatusTask status;

	public Task() {
	}

	public Task(String title, String description, Date dueDate, Set<User> users, Category category, Priority priority, StatusTask status) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.users = users;
		this.category = category;
		this.priority = priority;
		this.status = status;
	}

	public Task(Long id, String title, String description, Date dueDate, Set<User> users, Category category,
			Priority priority, StatusTask status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.users = users;
		this.category = category;
		this.priority = priority;
		this.status = status;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public StatusTask getStatus() {
		return status;
	}

	public void setStatus(StatusTask status) {
		this.status = status;
	}
	
}
