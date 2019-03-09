package com.akapush.plm.service.internal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.UserDAO;
import com.akapush.plm.domain.enumartion.BeanType;
import com.akapush.plm.domain.exception.AlreadyExistingBeanException;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.User;
import com.akapush.plm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");

			byte[] messageDigest = md.digest(password.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Iterable<User> getAllActiveUsers() {
		return userDAO.findByActive(true);
	}

	@Override
	public void saveUser(User user)
			throws AlreadyExistingBeanException, InvalidBeanException, NoBeanAvailableException {
		if (CheckIfUserIsValid(user)) {
			throw new InvalidBeanException("Le nom et l'email sont obligatoire");
		}
		Long userId = user.getId();
		user.setActive(true);
		if (userId != null) {
			updateExistingUser(user);
		} else {
			createNewUser(user);
		}

	}

	@Override
	public void deleteUserById(Long userId) throws NoBeanAvailableException {
		Optional<User> userOpt = userDAO.findById(userId);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			user.setActive(false);
			userDAO.save(user);
		} else {
			throw new NoBeanAvailableException(BeanType.USER, userId);
		}

	}

	private void updateExistingUser(User user) throws NoBeanAvailableException, AlreadyExistingBeanException {
		Optional<User> existingUserIdOptional = userDAO.findById(user.getId());
		if (existingUserIdOptional.isPresent()) {
			String email = user.getEmail();
			User sameEmailUser = userDAO.findByEmailAndActive(email, true);
			// Check if the user email is not already set for another user
			if (sameEmailUser == null || sameEmailUser.getId().equals(user.getId())) {

				User existingUser = existingUserIdOptional.get();
				existingUser.setEmail(user.getEmail());
				existingUser.setFirstname(user.getFirstname());
				existingUser.setLastname(user.getLastname());
				String password = user.getPassword();
				if (!StringUtils.isEmpty(password)) {
					PasswordEncoder encoder = new BCryptPasswordEncoder();
					existingUser.setPassword(encoder.encode(password));
				}
				userDAO.save(existingUser);
			} else {
				throw new AlreadyExistingBeanException();
			}
		} else {
			throw new NoBeanAvailableException(BeanType.USER, user.getId());
		}

	}

	private void createNewUser(User user) throws AlreadyExistingBeanException, InvalidBeanException {
		User existingUserEmail = userDAO.findByEmailAndActive(user.getEmail(), true);
		if (existingUserEmail != null) {
			throw new AlreadyExistingBeanException();
		}
		String password = user.getPassword();
		if (StringUtils.isEmpty(password)) {
			throw new InvalidBeanException("Le mot de passe est obligatoire pour un nouvel utilisateur");
		}
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));
		userDAO.save(user);
	}

	private boolean CheckIfUserIsValid(User user) {
		return user == null || StringUtils.isEmpty(user.getLastname()) || StringUtils.isEmpty(user.getEmail());
	}

}
