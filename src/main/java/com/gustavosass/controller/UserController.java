package com.gustavosass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavosass.model.User;
import com.gustavosass.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(userServiceImpl.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok(userServiceImpl.findById(id));
	}
	
	@GetMapping("/document/{document}")
	public ResponseEntity<User> findByDocument(@PathVariable Long document){
		return ResponseEntity.ok(userServiceImpl.findByDocument(document));
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		User userCreated = userServiceImpl.create(user);
		return ResponseEntity.ok(userCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		User userUpdated = userServiceImpl.update(id, user);
		return ResponseEntity.ok(userUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		userServiceImpl.delete(id);
		return ResponseEntity.ok().build();
	}
}
