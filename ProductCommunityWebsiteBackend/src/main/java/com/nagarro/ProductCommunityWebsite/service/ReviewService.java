package com.nagarro.ProductCommunityWebsite.service;

import org.springframework.http.ResponseEntity;

import com.nagarro.ProductCommunityWebsite.entity.ReviewEntity;

public interface ReviewService {
	public ResponseEntity<Object> postReview(int productCode, ReviewEntity reviewModel);

	public ResponseEntity<Object> deleteReview(int reviewId);

	public ResponseEntity<Object> approveReview(int reviewId);

	public ResponseEntity<Object> getPendingReviews();

}
