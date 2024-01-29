package com.nagarro.ProductCommunityWebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductCommunityWebsite.service.ProductsService;

@RestController
@RequestMapping("products")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	ProductsService productService;

	// method to get all products
	@GetMapping("")
	public ResponseEntity<Object> getAllProductsDetails() {
		return productService.getAllProductsDetails();
	}

	// method to get a single product by its code
	@GetMapping("/{productCode}")
	public ResponseEntity<Object> getProductsDetailsByProductCode(
			@PathVariable(value = "productCode", required = true) int productCode) {
		return productService.getProductsDetailsByProductCode(productCode);
	}

	// method to search product
	@GetMapping("/search-products")
	public ResponseEntity<Object> getSearchResults(@RequestParam(required = true) String keyWord) {
		return productService.getProductsResultForNameBrandOrCode(keyWord);
	}

	// method to get stats like user count, reviews, products
	@GetMapping("/get-stats")
	public ResponseEntity<Object> getStats() {
		return productService.getStats();
	}

}
