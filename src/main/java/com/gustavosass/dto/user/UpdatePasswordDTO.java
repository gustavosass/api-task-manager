package com.gustavosass.dto.user;

import jakarta.validation.constraints.NotBlank;

public class UpdatePasswordDTO {
	
	@NotBlank
	private String password;
	@NotBlank
	private String newPassword;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
