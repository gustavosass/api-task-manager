package com.gustavosass.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
		return  userRepository.findByDocument(document).orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public List<User> findAllByIds(List<Long> ids) {
		return userRepository.findAllById(ids);
	}

	@Override
	public User create(User user) {
		Optional<User> userExists = userRepository.findByDocument(user.getDocument());
		if(userExists.isPresent()) {
			throw new HttpClientErrorException(HttpStatus.CONFLICT,"Documento já cadastrado");
		}
		return userRepository.save(user);
		
	}

	@Override
	public User update(Long id, User user) {
		Optional<User> userExists = userRepository.findById(id);
		if(userExists.isPresent()) {
			return userRepository.save(user);
		}
		throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED, "Erro ao atualizar usuário.");
		
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public boolean existsUsersById(List<Long> ids) {
		List<Long> usersFound = this.findAllByIds(ids).stream().map(n -> n.getId()).collect(Collectors.toList());
		return usersFound.containsAll(ids);
	}
	

}
