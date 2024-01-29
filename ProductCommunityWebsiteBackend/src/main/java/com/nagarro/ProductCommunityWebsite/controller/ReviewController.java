package com.nagarro.ProductCommunityWebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductCommunityWebsite.entity.ReviewEntity;
import com.nagarro.ProductCommunityWebsite.service.ReviewService;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "*")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	// method to add review
	@PostMapping("/add-review/{productCode}")
	public ResponseEntity<Object> postReview(@PathVariable(value = "productCode", required = true) int productCode,
			@RequestBody(required = true) ReviewEntity reviewModel) {
		return reviewService.postReview(productCode, reviewModel);
	}

	// method to delete/reject review
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<Object> deleteReview(@PathVariable(value = "reviewId", required = true) int reviewId) {
		return reviewService.deleteReview(reviewId);
	}

	// method to approve review
	@PutMapping("/{reviewId}")
	public ResponseEntity<Object> updateReview(@PathVariable(value = "reviewId") int reviewId,
			@RequestBody(required = true) ReviewEntity reviewModel) {
		return reviewService.approveReview(reviewId);
	}

	// method to fetch pending reviews
	@GetMapping("/pending-reviews")
	public ResponseEntity<Object> getPendingReviews() {
		return reviewService.getPendingReviews();
	}

}
