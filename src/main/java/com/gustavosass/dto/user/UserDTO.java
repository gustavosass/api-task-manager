package com.gustavosass.dto.user;

import java.util.Set;

import com.gustavosass.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

	private Long id;
	
	@NotBlank(message = "Name is blank")
	private String name;
	
	private String username;
	

	private Long document;
	
	@NotBlank(message = "Mail is blank")
	@Email(message = "Invalid mail")
	private String mail;
	
	private Set<Role> roles;
	
	public UserDTO() {}
	
	public UserDTO(Long id, String name, String username, Long document, String mail, Set<Role> roles) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.document = document;
		this.mail = mail;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
