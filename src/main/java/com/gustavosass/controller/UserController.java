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

import com.gustavosass.dto.user.CreateUserDTO;
import com.gustavosass.dto.user.UpdatePasswordDTO;
import com.gustavosass.dto.user.UserDTO;
import com.gustavosass.mapper.UserMapper;
import com.gustavosass.model.User;
import com.gustavosass.service.impl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> listUserDto = userServiceImpl.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
		return ResponseEntity.ok(listUserDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO userDto = userMapper.toDto(userServiceImpl.findById(id));
		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping("/document/{document}")
	public ResponseEntity<UserDTO> findByDocument(@PathVariable Long document){
		UserDTO userDto = userMapper.toDto(userServiceImpl.findByDocument(document));
		return ResponseEntity.ok(userDto);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody @Valid CreateUserDTO userCreateDTO){
		User user = userMapper.toUser(userCreateDTO);
		User userCreated = userServiceImpl.create(user);
		UserDTO userDto = userMapper.toDto(userCreated);
		return ResponseEntity.ok(userDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserDTO userDto){
		User user = userMapper.toUser(userDto);
		User userUpdated = userServiceImpl.update(id, user);
		UserDTO updatedUserDto = userMapper.toDto(userUpdated);
		return ResponseEntity.ok(updatedUserDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		userServiceImpl.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}/password")
	public ResponseEntity<UserDTO> updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordDTO updatePasswordDto){
		UserDTO userDto = userMapper.toDto(userServiceImpl.updatePassword(id, updatePasswordDto));
		return ResponseEntity.ok(userDto);
	}
	
}
