package com.gustavosass.dto.user;

import java.util.Set;

import com.gustavosass.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateUserDTO {
	
	@NotBlank(message = "Name is blank")
	private String name;
	
	private Long document;
	
	private String username;
	
	@NotBlank(message = "Mail is blank")
	@Email(message = "Invalid mail")
	private String mail;
	
	@NotBlank(message = "Password is blank")
	private String password;
	
	private Set<Role> roles;

	public CreateUserDTO() {}
	
	public CreateUserDTO(String name, String username, Long document, String mail, String password, Set<Role> roles) {
		this.name = name;
		this.username = username;
		this.document = document;
		this.mail = mail;
		this.password = password;
		this.roles = roles;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
