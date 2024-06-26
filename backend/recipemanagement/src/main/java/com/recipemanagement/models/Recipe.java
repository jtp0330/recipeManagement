package com.recipemanagement.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "recipes")
public class Recipe {

	@Id
	@Indexed(unique = true)
	private ObjectId id;
	@Field("recipeName")
	private String recipeName;
	@Field("description")
	private String description;
	@Field("ingredients")
	private String ingredients;
	@Field("cookingSteps")
	private String cookingSteps;
	// reference back to User One To Many
	@Field("user")
	@DocumentReference(lazy = true)
	private User user;
	// stretch goal
	// private byte[] imageData;

	public Recipe() {
	}

	public Recipe(ObjectId id, String recipeName, String description, String ingredients, String cookingSteps
	// byte[] imageData) {
	) {
		this.id = id;
		this.description = description;
		this.ingredients = ingredients;
		this.cookingSteps = cookingSteps;
		// this.imageData = imageData;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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
	// public byte[] getImageData() {
	// return imageData;
	// }
	// public void setImageData(byte[] imageData) {
	// this.imageData = imageData;
	// }

}
