package com.gustavosass.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavosass.dto.user.UpdatePasswordDTO;
import com.gustavosass.model.User;

@Service
public interface UserService{
		
	List<User> findAll();
	
	List<User> findAllByIds(List<Long> ids);
	
	User findById(Long id);
	
	User findByDocument(Long document);
	
	User findByUsername(String username);
	
	User create(User user);
	
	User update(Long id, User user);
	
	User updatePassword(Long id, UpdatePasswordDTO updatePasswordDto);
	
	void delete(Long id);
}
