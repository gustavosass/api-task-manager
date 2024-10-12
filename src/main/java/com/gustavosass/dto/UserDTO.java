package com.gustavosass.dto;

public class UserDTO {

	private Long id;
	private String name;
	private Long document;
	private String mail;
	
	public UserDTO() {}
	
	public UserDTO(Long id, String name, Long document, String mail) {
		this.id = id;
		this.name = name;
		this.document = document;
		this.mail = mail;
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
	
}
