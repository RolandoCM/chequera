/**
 * 
 */
package com.gfi.chequera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gfi.chequera.entity.User;
import com.gfi.chequera.service.impl.UserService;

/**
 * @author rolando
 *
 */
@RestController
public class ControllerLogin {
	@Autowired
	UserService userService;
	@PostMapping("/login")
	@ResponseStatus
	public ResponseEntity<User> login(@RequestBody User user){
		User userA = userService.getLogin(user.getMail(), user.getPassword());
		
		System.out.println("mail-->"+user.getMail());
		return new ResponseEntity<User>(userA, HttpStatus.OK);
	}

}
