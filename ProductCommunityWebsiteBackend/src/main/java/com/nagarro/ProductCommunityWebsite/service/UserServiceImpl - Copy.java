package com.nagarro.ProductCommunityWebsite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsite.dao.UserDao;
import com.nagarro.ProductCommunityWebsite.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	// method to get user by their email id
	@Override
	public ResponseEntity<Object> getUserByEmail(String id) {
		Optional<UserEntity> userEntity = userDao.findById(id);
		if (userEntity.isPresent()) {
			return ResponseHandler.generateResponse("success", HttpStatus.OK, userEntity);
		} else {
			return ResponseHandler.generateResponse("NO_USER", HttpStatus.NOT_FOUND, null);
		}
	}

	// method to register new user
	@Override
	public ResponseEntity<Object> registerNewUser(UserEntity userEntity) {
		Optional<UserEntity> userEntityPresent = userDao.findById(userEntity.getEmail());
		if (userEntityPresent.isPresent()) {
			return ResponseHandler.generateResponse("USER_EXIST", HttpStatus.BAD_REQUEST,
					null);
		}
		try {
			UserEntity returnedUserEntity = userDao.save(userEntity);
			return ResponseHandler.generateResponse("success", HttpStatus.OK,
					returnedUserEntity);
		} catch (Exception e) {
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
}
