package com.gustavosass.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.gustavosass.dto.UpdatePasswordDTO;
import com.gustavosass.dto.UserCreateDTO;
import com.gustavosass.dto.UserDTO;
import com.gustavosass.mapper.UserMapper;
import com.gustavosass.model.User;
import com.gustavosass.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		return ResponseEntity.ok(userServiceImpl.findAll().stream().map(userMapper::toDto).collect(Collectors.toList()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(userMapper.toDto(userServiceImpl.findById(id)));
	}
	
	@GetMapping("/document/{document}")
	public ResponseEntity<UserDTO> findByDocument(@PathVariable Long document){
		return ResponseEntity.ok(userMapper.toDto(userServiceImpl.findByDocument(document)));
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserCreateDTO userCreateDTO){
		User user = userMapper.toUser(userCreateDTO);
		User userCreated = userServiceImpl.create(user);
		return ResponseEntity.ok(userMapper.toDto(userCreated));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDto){
		User user = userMapper.toUser(userDto);
		User userUpdated = userServiceImpl.update(id, user);
		return ResponseEntity.ok(userMapper.toDto(userUpdated));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		userServiceImpl.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}/password")
	public ResponseEntity<UserDTO> updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordDTO updatePasswordDto){
		return ResponseEntity.ok(userMapper.toDto(userServiceImpl.updatePassword(id, updatePasswordDto)));
	}
}
