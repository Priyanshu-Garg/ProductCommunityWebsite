package com.nagarro.ProductCommunityWebsite.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Id
	@Column(name = "productCode")
	private int productCode;
	@Column(name = "productName")
	private String productName;
	@Column(name = "brand")
	private String brand;
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("product")
	private Set<ReviewEntity> review;

	public ProductEntity() {
		super();
	}

	public ProductEntity(int productCode, String productName, String brand, Set<ReviewEntity> review) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.brand = brand;
		this.review = review;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Set<ReviewEntity> getReview() {
		return review;
	}

	public void setReview(Set<ReviewEntity> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "ProductEntity [productCode=" + productCode + ", productName=" + productName + ", brand=" + brand
				+ ", review=" + review + "]";
	}

}
