package com.akapush.plm.service;

import com.akapush.plm.domain.exception.AlreadyExistingBeanException;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.User;

public interface UserService {

	/**
	 * Return all users
	 * 
	 * @return
	 */
	Iterable<User> getAllActiveUsers();

	/**
	 * Save new or existing user
	 * 
	 * @param user
	 * @throws AlreadyExistingBeanException
	 * @throws InvalidBeanException
	 * @throws NoBeanAvailableException
	 */
	void saveUser(User user) throws AlreadyExistingBeanException, InvalidBeanException, NoBeanAvailableException;

	/**
	 * Delete user specified by id
	 * 
	 * @param userId
	 * @throws NoBeanAvailableException
	 */
	void deleteUserById(Long userId) throws NoBeanAvailableException;

}
