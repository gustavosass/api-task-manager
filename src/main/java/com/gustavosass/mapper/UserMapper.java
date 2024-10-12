package com.gustavosass.mapper;

import org.springframework.stereotype.Component;

import com.gustavosass.dto.UserCreateDTO;
import com.gustavosass.dto.UserDTO;
import com.gustavosass.model.User;

@Component
public class UserMapper {
	
	public UserDTO toDto(User user) {
		Long id = user.getId();
		String name = user.getName();
		Long document = user.getDocument();
		String mail = user.getMail();
		return new UserDTO(id, name, document, mail);
	}
	
	public User toUser(UserCreateDTO userCreateDTO) {
		String name = userCreateDTO.getName();
		Long document = userCreateDTO.getDocument();
		String mail = userCreateDTO.getMail();
		String password = userCreateDTO.getPassword();
		return new User(name, document, mail, password);
	}
	
	public User toUser(UserDTO userDto) {
		Long id = userDto.getId();
		String name = userDto.getName();
		Long document = userDto.getDocument();
		String mail = userDto.getMail();
		return new User(id, name, document, mail);
	}
}
