package com.recipemanagement.models;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Document(collection = "recipes")
public class Recipe {

	@Id
	@Indexed(unique = true)
	private String id;
	@NotEmpty(message = "recipe must have a name!")
	@Field("recipeName")
	private String recipeName;
	@NotEmpty(message = "please describe your recipe!")
	@Field("description")
	private String description;
	@NotEmpty(message = "recipe must have ingredients!")
	@Field("ingredients")
	private String ingredients;
	@NotEmpty(message = "recipe must have steps!")
	@Field("cookingSteps")
	private String cookingSteps;
	@NotEmpty(message = "please upload a picture of your recipe!")
	@Field("recipePicture")
	private String recipePic;
	// reference back to User One To Many
	@Field("user")
	@DocumentReference(lazy = true)
	private User user;
	// stretch goal

	public Recipe() {
	}

	public Recipe(Recipe recipe) {
		this.id = recipe.getId();
		this.description = recipe.getDescription();
		this.ingredients = recipe.getIngredients();
		this.cookingSteps = recipe.getCookingSteps();
		this.recipePic = recipe.getRecipePic();
	}

	public Recipe(String id, String recipeName, String description, String ingredients, String cookingSteps,
			String recipePic) {

		this.id = id;
		this.recipeName = recipeName;
		this.description = description;
		this.ingredients = ingredients;
		this.cookingSteps = cookingSteps;
		this.recipePic = recipePic;
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

	public String getRecipePic() {
		return recipePic;
	}

	public void setRecipePic(String recipePic) {
		this.recipePic = recipePic;
	}

}
