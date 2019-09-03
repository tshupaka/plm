package com.akapush.plm.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.akapush.plm.domain.dto.UserDTO;
import com.akapush.plm.domain.model.User;

@Component
public class UserHelper {

	public UserDTO getUserDTO(User user) {
		if (user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLastname(user.getLastname());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}

	public User getUser(UserDTO userDTO) {
		if (userDTO == null) {
			return null;
		}
		User user = new User();
		user.setId(userDTO.getId());
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		return user;
	}

	public List<UserDTO> getUsersDTO(Iterable<User> users) {
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User user : users) {
			usersDTO.add(getUserDTO(user));
		}
		return usersDTO;
	}
}
