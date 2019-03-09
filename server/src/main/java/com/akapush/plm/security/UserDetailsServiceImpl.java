package com.akapush.plm.security;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.UserDAO;
import com.akapush.plm.domain.model.User;

/**
 * Service permettant de récuprer les informations de l'utilisateur à partir de
 * son email.
 * 
 * @author eric
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByEmailAndActive(username, true);
		if (user == null || !user.getActive()) {
			throw new UsernameNotFoundException(username);
		}
		return new UserContext(user.getId(), user.getEmail(), user.getPassword(), emptyList());
	}
}