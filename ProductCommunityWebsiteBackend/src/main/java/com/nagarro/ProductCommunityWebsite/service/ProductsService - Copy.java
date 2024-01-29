package com.nagarro.ProductCommunityWebsite.service;

import org.springframework.http.ResponseEntity;

public interface ProductsService {
	public ResponseEntity<Object> getAllProductsDetails();

	public ResponseEntity<Object> getProductsDetailsByProductCode(int productCode);

	public ResponseEntity<Object> getStats();

	public ResponseEntity<Object> getProductsResultForNameBrandOrCode(String keyWord);

}
