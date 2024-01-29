package com.nagarro.ProductCommunityWebsite.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsite.dao.ReviewDao;
import com.nagarro.ProductCommunityWebsite.entity.ProductEntity;
import com.nagarro.ProductCommunityWebsite.entity.ReviewEntity;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao reviewDao;

	// method to post review
	@Override
	public ResponseEntity<Object> postReview(int productCode, ReviewEntity reviewEntity) {
		try {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductCode(productCode);
			reviewEntity.setProduct(productEntity);
			ReviewEntity returnedReviewEntity = reviewDao.save(reviewEntity);
			return ResponseHandler.generateResponse("success", HttpStatus.OK,
					returnedReviewEntity);
		} catch (Exception e) {
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	// method to delete review
	@Override
	public ResponseEntity<Object> deleteReview(int reviewId) {
		try {
			reviewDao.deleteById(reviewId);
		} catch (Exception e) {
			return ResponseHandler.generateResponse("NO_REVIEW", HttpStatus.NOT_FOUND, null);
		}
		return ResponseHandler.generateResponse("success", HttpStatus.OK, null);
	}

	// method to approve review
	@Override
	public ResponseEntity<Object> approveReview(int reviewId) {
		ReviewEntity reviewEntity = reviewDao.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("NO_REVIEW"));
		reviewEntity.setReviewStatus(true);
		ReviewEntity returnedReviewEntity = reviewDao.save(reviewEntity);
		return ResponseHandler.generateResponse("success", HttpStatus.OK,
				returnedReviewEntity);
	}

	// method to fetch pending reviews to be approved
	@Override
	public ResponseEntity<Object> getPendingReviews() {
		Set<ReviewEntity> reviewEntityList = reviewDao.getPendingReviews();
		Set<ReviewEntity> reviewModelList = new HashSet<ReviewEntity>();
		reviewDao.getPendingReviews().forEach(reviewEntityList::add);

		for (ReviewEntity reviewEntity : reviewEntityList) {
			reviewModelList.add(reviewEntity);
		}
		return ResponseHandler.generateResponse("success", HttpStatus.OK, reviewModelList);
	}
}
