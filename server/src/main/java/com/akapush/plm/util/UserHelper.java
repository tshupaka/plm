package com.akapush.plm.util;

import org.springframework.stereotype.Component;

import com.akapush.plm.domain.dto.UserDTO;
import com.akapush.plm.domain.model.User;

@Component
public class UserHelper {

	public UserDTO getUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLastname(user.getLastname());
		userDTO.setLogin(user.getLogin());
		return userDTO;
	}

	public User getUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setLogin(userDTO.getLogin());
		return user;
	}
}
