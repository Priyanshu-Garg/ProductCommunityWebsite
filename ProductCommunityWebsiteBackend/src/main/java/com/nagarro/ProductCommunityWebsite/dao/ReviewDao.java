package com.nagarro.ProductCommunityWebsite.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.nagarro.ProductCommunityWebsite.entity.ReviewEntity;

@RepositoryRestController
public interface ReviewDao extends JpaRepository<ReviewEntity, Integer> {

	// this is a query annotated function that will run given query as its
	// execution. it will select those review whose status is false and are yet to
	// be approved by admin
	@Query("SELECT r FROM ReviewEntity r where r.reviewStatus=FALSE")
	Set<ReviewEntity> getPendingReviews();

}
