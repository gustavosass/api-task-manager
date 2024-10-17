package com.gustavosass.model;

import java.util.HashSet;
import java.util.Set;

import com.gustavosass.enums.Role;

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

@Entity(name = "tb_user")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;
	private String name;
	private String username;
	private Long document;
	private String mail;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_users_roles", joinColumns = @JoinColumn(name = "id_user"))
    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Set<Role> roles = new HashSet<>();
	
	public User() {
	}

	public User(String name, String username, Long document, String mail, String password, Set<Role> roles) {
		this.name = name;
		this.username = username;
		this.document = document;
		this.mail = mail;
		this.password = password;
		this.roles = roles;
	}

	public User(long id, String name, String username, Long document, String mail, Set<Role> roles) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.document = document;
		this.mail = mail;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
