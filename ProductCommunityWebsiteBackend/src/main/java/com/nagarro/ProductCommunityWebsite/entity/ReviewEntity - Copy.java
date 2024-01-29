package com.nagarro.ProductCommunityWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "review")
public class ReviewEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "reviewId")
	private int reviewId;
	@Column(name = "heading")
	private String heading;
	@Column(name = "reviewComment")
	private String reviewComment;
	@Column(name = "reviewStatus")
	private boolean reviewStatus;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "productEntityId")

	private ProductEntity product;

	public ReviewEntity() {
		super();
	}

	public ReviewEntity(int reviewId, String heading, String reviewComment, boolean reviewStatus) {
		super();
		this.reviewId = reviewId;
		this.heading = heading;
		this.reviewComment = reviewComment;
		this.reviewStatus = reviewStatus;
	}

	public ReviewEntity(int reviewId, ProductEntity product, String heading, String reviewComment,
			boolean reviewStatus) {
		super();
		this.reviewId = reviewId;
		this.product = product;
		this.heading = heading;
		this.reviewComment = reviewComment;
		this.reviewStatus = reviewStatus;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public boolean isReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(boolean reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	@Override
	public String toString() {
		return "ReviewEntity [reviewId=" + reviewId + ", heading=" + heading + ", reviewComment="
				+ reviewComment + ", reviewStatus=" + reviewStatus + ", product=" + product + "]";
	}

}
