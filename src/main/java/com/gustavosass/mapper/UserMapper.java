package com.gustavosass.mapper;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.gustavosass.dto.user.CreateUserDTO;
import com.gustavosass.dto.user.UserDTO;
import com.gustavosass.enums.Role;
import com.gustavosass.model.User;

@Component
public class UserMapper {
	
	public UserDTO toDto(User user) {
		Long id = user.getId();
		String name = user.getName();
		String username = user.getUsername();
		Long document = user.getDocument();
		String mail = user.getMail();
		Set<Role> roles = user.getRoles();
		return new UserDTO(id, name, username, document, mail, roles);
	}
	
	public User toUser(CreateUserDTO userCreateDTO) {
		String name = userCreateDTO.getName();
		String username = userCreateDTO.getUsername();
		Long document = userCreateDTO.getDocument();
		String mail = userCreateDTO.getMail();
		String password = userCreateDTO.getPassword();
		Set<Role> roles = userCreateDTO.getRoles();
		return new User(name, username, document, mail, password, roles);
	}
	
	public User toUser(UserDTO userDto) {
		Long id = userDto.getId();
		String name = userDto.getName();
		String username = userDto.getUsername();
		Long document = userDto.getDocument();
		String mail = userDto.getMail();
		Set<Role> roles = userDto.getRoles();
		return new User(id, name, username, document, mail, roles);
	}
}
