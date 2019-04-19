package com.akapush.plm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akapush.plm.domain.dto.UserDTO;
import com.akapush.plm.domain.exception.AlreadyExistingBeanException;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.User;
import com.akapush.plm.service.UserService;
import com.akapush.plm.util.UserHelper;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserHelper userHelper;

	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllActiveUsers() {
		Iterable<User> users = userService.getAllActiveUsers();
		List<UserDTO> usersDTO = userHelper.getUsersDTO(users);
		return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/user", method = RequestMethod.POST)
	public ResponseEntity<List<UserDTO>> saveUser(@RequestBody UserDTO userDTO) {
		User user = userHelper.getUser(userDTO);
		try {
			userService.saveUser(user);
			return getAllActiveUsers();
		} catch (AlreadyExistingBeanException e) {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (InvalidBeanException e) {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.BAD_REQUEST);
		} catch (NoBeanAvailableException e) {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/api/user/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<List<UserDTO>> deleteUser(@PathVariable("userId") Long userId) {
		try {
			userService.deleteUserById(userId);
			return getAllActiveUsers();
		} catch (NoBeanAvailableException e) {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.BAD_REQUEST);
		}
	}

}
