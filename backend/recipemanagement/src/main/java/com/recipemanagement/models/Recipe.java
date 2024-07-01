package com.recipemanagement.models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotEmpty;

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
	@Field("recipePicture")
	private Binary recipePic;
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
			Binary recipePic) {

		this.id = id;
		this.recipeName = recipeName;
		this.description = description;
		this.ingredients = ingredients;
		this.cookingSteps = cookingSteps;
		this.recipePic = recipePic;
	}

	// overloaded constructor required for post request
	public Recipe(String recipeName, String description, String ingredients,
			String cookingSteps,
			Binary recipePic) {
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

	public Binary getRecipePic() {
		return recipePic;
	}

	public void setRecipePic(Binary recipePic) {
		this.recipePic = recipePic;
	}

}
