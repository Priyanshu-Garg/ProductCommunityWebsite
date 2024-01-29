package com.nagarro.ProductCommunityWebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductCommunityWebsite.entity.UserEntity;
import com.nagarro.ProductCommunityWebsite.service.UserService;

@RestController
@RequestMapping("userlogin")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;

	// method for login
	@PutMapping("/login")
	public ResponseEntity<Object> login(@RequestBody(required = true) String emailId) {
		return userService.getUserByEmail(emailId);
	}

	// method for registration of new user
	@PostMapping("/sign-up")
	public ResponseEntity<Object> registerNewUser(@RequestBody(required = true) UserEntity userModel) {
		return userService.registerNewUser(userModel);
	}

}
