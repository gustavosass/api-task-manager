package com.gustavosass.dto;


public class UserCreateDTO {
	
	private String name;
	private Long document;
	private String mail;
	private String password;
	
	public UserCreateDTO() {}
	
	public UserCreateDTO(String name, Long document, String mail, String password) {
		this.name = name;
		this.document = document;
		this.mail = mail;
		this.password = password;
	}

	public String getName() {
		return this.name;
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
