package com.recipemanagement.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Document(collection = "users")
public class User {
	@Id
	@Indexed(unique = true)
	@JsonProperty("_id")
	@JsonSerialize(using = ToStringSerializer.class)
	private String id;
	@Field("firstName")
	@JsonProperty("firstName")
	private String firstName;
	@Field("lastName")
	@JsonProperty("lastName")
	private String lastName;
	@NotEmpty(message = "Email is required!")
	@Email(message = "Please enter a valid email!")
	@Field("email")
	@JsonProperty("email")
	private String email;
	@NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
	@Field("password")
	@JsonProperty("password")
	private String password;
	@Transient
	@NotEmpty(message = "Confirm Password must be between 8 and 128 characters")
	@JsonProperty("confirmPassword")
	private String confirmPassword;

	// One To Many Recipes
	// @DocumentReference
	// @Field("recipes")
	// List<Recipe> recipes;

	public User() {
	}

	public User(String id, String firstName, String lastName, String email, String password, String confirmPassword) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;

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

}