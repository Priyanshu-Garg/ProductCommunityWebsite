package com.nagarro.ProductCommunityWebsite.service;

import org.springframework.http.ResponseEntity;

import com.nagarro.ProductCommunityWebsite.entity.UserEntity;

public interface UserService {

	public ResponseEntity<Object> getUserByEmail(String emailId);

	public ResponseEntity<Object> registerNewUser(UserEntity userModel);
}
