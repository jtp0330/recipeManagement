package com.recipemanagement.models;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Document(collection = "users")
public class User implements UserDetails {
	@Id
	@Indexed(unique = true)
	private String id;
	@Field("firstName")
	private String firstName;
	@Field("lastName")
	private String lastName;
	@NotEmpty(message = "Email is required!")
	@Email(message = "Please enter a valid email!")
	@Field("email")
	private String email;
	@NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
	@Field("password")
	private String password;
	@Transient
	@NotEmpty(message = "Confirm Password must be between 8 and 128 characters")
	@JsonProperty("confirmPassword")
	private String confirmPassword;
	@Field("createdAt")
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	@Field("updatedAt")
	private Date updatedAt;

	// One To Many Recipes
	// @DocumentReference
	// @Field("recipes")
	// List<Recipe> recipes;

	public User() {
	}

	public User(String id, String firstName, String lastName, String email, String password, String confirmPassword,
			Date createdAt, Date updatedAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedDate() {
		return createdAt;
	}

	public void setCreatedDate(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedDate() {
		return updatedAt;
	}

	public void setUpdatedDate(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	// required for spring security, but we do not use this
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

}