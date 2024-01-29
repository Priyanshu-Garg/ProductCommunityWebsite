package com.nagarro.ProductCommunityWebsite.entity;

public class Stats {
	private long noOfUsers;
	private long noOfProducts;
	private long noOfReviews;

	public Stats() {
		super();
	}

	public Stats(long noOfUsers, long noOfProducts, long noOfReviews) {
		super();
		this.noOfUsers = noOfUsers;
		this.noOfProducts = noOfProducts;
		this.noOfReviews = noOfReviews;
	}

	public long getNoOfUsers() {
		return noOfUsers;
	}

	public void setNoOfUsers(long noOfUsers) {
		this.noOfUsers = noOfUsers;
	}

	public long getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(long noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public long getNoOfReviews() {
		return noOfReviews;
	}

	public void setNoOfReviews(long noOfReviews) {
		this.noOfReviews = noOfReviews;
	}

}
