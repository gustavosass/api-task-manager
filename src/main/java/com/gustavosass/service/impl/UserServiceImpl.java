package com.gustavosass.service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.gustavosass.dto.user.UpdatePasswordDTO;
import com.gustavosass.enums.Role;
import com.gustavosass.model.User;
import com.gustavosass.repository.UserRepository;
import com.gustavosass.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());

	}

	@Override
	public User findByDocument(Long document) {
		return userRepository.findByDocument(document).orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public List<User> findAllByIds(List<Long> ids) {
		return userRepository.findAllById(ids);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Erro ao fazer login"));
	}

	@Override
	public User create(User user) {
		if (user.getDocument() <= 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Document can't zero or negative.");
		}
		Optional<User> userExists = userRepository.findByDocument(user.getDocument());
		if (userExists.isPresent()) {
			throw new HttpClientErrorException(HttpStatus.CONFLICT, "This document already exists.");
		}
			
		user.setPassword(user.getPassword());
		return userRepository.save(user);
	}

	@Override
	public User update(Long id, User user) {
		if (user.getDocument() <= 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Document can't zero or negative.");
		}
		
		Optional<User> userExists = userRepository.findById(id);

		if (userExists.isPresent()) {
			user.setPassword(userExists.get().getPassword());
			return userRepository.save(user);
		}

		throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED, "Error updating user.");
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updatePassword(Long id, UpdatePasswordDTO updatePasswordDto) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_MODIFIED, "User not find."));
		
		if (user.getPassword().equals(updatePasswordDto.getPassword())) {
			user.setPassword(updatePasswordDto.getNewPassword());
			return userRepository.save(user);
		}
		
		throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED, "Actual password is incorrect.");
	}

	public boolean existsUsersById(List<Long> ids) {
		List<Long> usersFound = this.findAllByIds(ids).stream().map(n -> n.getId()).collect(Collectors.toList());
		return usersFound.containsAll(ids);
	}

}
