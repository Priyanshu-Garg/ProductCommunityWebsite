package com.nagarro.ProductCommunityWebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.nagarro.ProductCommunityWebsite.entity.UserEntity;

@RepositoryRestController
public interface UserDao extends JpaRepository<UserEntity, String> {

}
