package com.gustavosass.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(unique = true, nullable = false)
	private Long document;
	private String mail;
	private String password;
	
	public User() {}
	
	public User(String name, Long document, String mail, String password) {
		this.name = name;
		this.document = document;
		this.mail = mail;
		this.password = password;
	}
	
	public User(long id, String name, Long document, String mail) {
		this.id = id;
		this.name = name;
		this.document = document;
		this.mail = mail;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public void setName(String name) {
		this.name = name;
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
}
