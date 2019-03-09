package com.akapush.plm.dao;

import org.springframework.data.repository.CrudRepository;

import com.akapush.plm.domain.model.User;

public interface UserDAO extends CrudRepository<User, Long> {

	/**
	 * Return all active users
	 * 
	 * @param active
	 * @return
	 */
	Iterable<User> findByActive(Boolean active);

	User findByEmailAndActive(String email, boolean active);

}
