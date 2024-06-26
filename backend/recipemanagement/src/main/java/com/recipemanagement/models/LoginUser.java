package com.recipemanagement.models;

import org.springframework.security.core.Authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {

	@NotEmpty(message = "Email is required!")
	@Email(message = "Please enter a valid email!")
	private String email;
	@NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
	private String password;
	// will use this object to hold secrets, JWTs, and other authentication info for
	// logged in user
	private Authentication authorities;

	public LoginUser() {
	}

	public LoginUser(String email, String password, Authentication authorities) {
		super();
		this.email = email;
		this.password = password;
		this.authorities = authorities;
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

	public Authentication getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authentication authorities) {
		this.authorities = authorities;
	}

}
