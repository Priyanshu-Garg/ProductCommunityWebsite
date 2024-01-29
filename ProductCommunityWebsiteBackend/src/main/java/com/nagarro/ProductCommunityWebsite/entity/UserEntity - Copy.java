package com.nagarro.ProductCommunityWebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@Column(name = "email")
	String email;
	@Column(name = "password")
	String password;
	@Column(name = "role")
	char role;
	@Column(name = "name")
	String name;

	public UserEntity() {
		super();
	}

	public UserEntity(String email, String password, char role, String name) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getRole() {
		return role;
	}

	public void setRole(char role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
