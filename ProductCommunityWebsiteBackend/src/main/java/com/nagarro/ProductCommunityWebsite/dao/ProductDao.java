package com.nagarro.ProductCommunityWebsite.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.nagarro.ProductCommunityWebsite.entity.ProductEntity;

@RepositoryRestController
public interface ProductDao extends JpaRepository<ProductEntity, Integer> {

	// this is a query annotated function which as execution will run this query and
	// will provide search product result

	@Query("SELECT p FROM ProductEntity p where p.productName LIKE %?1%" + "OR p.brand LIKE %?1%"
			+ "OR p.productCode LIKE %?1%")
	Set<ProductEntity> getSearchResults(String keyWord);

}
