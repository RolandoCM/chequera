/**
 * 
 */
package com.gfi.chequera.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.entity.User;
import com.gfi.chequera.repository.UserRepository;
import com.gfi.chequera.service.IUserService;

/**
 * @author rolando
 *
 */
@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public User getLogin(String mail, String password) {
		User user =userRepository.findByMail(mail);
		return user;
	}
	
}
