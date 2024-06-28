package com.recipemanagement.models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.NotNull;

@Document(collection = "recipes")
public class Recipe {

	@Id
	@Indexed(unique = true)
	private String id;
	@Field("recipeName")
	private String recipeName;
	@Field("description")
	private String description;
	@Field("ingredients")
	private String ingredients;
	@Field("cookingSteps")
	private String cookingSteps;
	@Field("recipePicture")
	private Binary photo;
	// reference back to User One To Many
	@Field("user")
	@DocumentReference(lazy = true)
	private User user;
	// stretch goal

	public Recipe() {
	}

	public Recipe(String id, String recipeName, String description, String ingredients, String cookingSteps,
			Binary photo) {

		this.id = id;
		this.recipeName = recipeName;
		this.description = description;
		this.ingredients = ingredients;
		this.cookingSteps = cookingSteps;
		this.photo = photo;
	}

	public Recipe(String recipeName, String description, String ingredients, String cookingSteps,
			Binary photo) {

		this.recipeName = recipeName;
		this.description = description;
		this.ingredients = ingredients;
		this.cookingSteps = cookingSteps;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecipeName() {
		return this.recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCookingSteps() {
		return cookingSteps;
	}

	public void setCookingSteps(String cookingSteps) {
		this.cookingSteps = cookingSteps;
	}

	public Binary getPhoto() {
		return photo;
	}

	public void setPhoto(Binary photo) {
		this.photo = photo;
	}

}
