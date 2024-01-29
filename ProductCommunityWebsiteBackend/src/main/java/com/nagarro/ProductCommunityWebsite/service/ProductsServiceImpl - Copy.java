package com.nagarro.ProductCommunityWebsite.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.ProductCommunityWebsite.dao.ProductDao;
import com.nagarro.ProductCommunityWebsite.dao.ReviewDao;
import com.nagarro.ProductCommunityWebsite.dao.UserDao;
import com.nagarro.ProductCommunityWebsite.entity.ProductEntity;
import com.nagarro.ProductCommunityWebsite.entity.Stats;

@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	ProductDao productDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ReviewDao reviewDao;

	// method to get all product details
	@Override
	public ResponseEntity<Object> getAllProductsDetails() {
		try {
			List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();
			productDao.findAll().forEach(productEntityList::add);
			if (productEntityList.isEmpty()) {
				return ResponseHandler.generateResponse("success", HttpStatus.NO_CONTENT, null);
			}
			return ResponseHandler.generateResponse("success", HttpStatus.OK, productEntityList);
		} catch (Exception e) {
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	// method to fetch product details by its code
	@Override
	public ResponseEntity<Object> getProductsDetailsByProductCode(int productCode) {
		Optional<ProductEntity> productEntity = productDao.findById(productCode);
		if (productEntity.isPresent()) {
			return ResponseHandler.generateResponse("success", HttpStatus.OK, productEntity);
		} else {
			return ResponseHandler.generateResponse("NO_PRODUCT", HttpStatus.NOT_FOUND, null);
		}
	}

	// method to get stats data
	@Override
	public ResponseEntity<Object> getStats() {
		Stats stats = new Stats();
		stats.setNoOfProducts(productDao.count());
		stats.setNoOfReviews(reviewDao.count());
		stats.setNoOfUsers(userDao.count());
		return ResponseHandler.generateResponse("success", HttpStatus.OK, stats);
	}

	// method for search of the product
	@Override
	public ResponseEntity<Object> getProductsResultForNameBrandOrCode(String keyWord) {
		Set<ProductEntity> searchedProductsEntity = productDao.getSearchResults(keyWord);
		Set<ProductEntity> productModel = new HashSet<ProductEntity>();
		searchedProductsEntity.forEach((ProductEntity productEntity) -> {
			productModel.add(productEntity);
		});
		return ResponseHandler.generateResponse("success", HttpStatus.OK, productModel);
	}

}
