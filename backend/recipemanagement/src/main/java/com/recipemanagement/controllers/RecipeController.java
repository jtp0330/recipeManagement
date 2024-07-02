package com.recipemanagement.controllers;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.recipemanagement.models.Recipe;
import com.recipemanagement.services.RecipeService;

import jakarta.validation.Valid;

@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;

	// // template to interact with MongoDB Connection
	// MongoTemplate mongoTemplate = null;

	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/recipes")
	public List<Recipe> recipeHome() {
		return recipeService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("/recipes/add")
	public ResponseEntity<?> addRecipe(
			@Valid @RequestParam("recipeName") String recipeName,
			@Valid @RequestParam("description") String description,
			@Valid @RequestParam("ingredients") String ingredients,
			@Valid @RequestParam("cookingSteps") String cookingSteps,
			@Valid @RequestParam("recipePic") MultipartFile recipePic) throws IOException {
		// add recipe
		Recipe recipe = new Recipe(recipeName, description, ingredients,
				cookingSteps, new Binary(BsonBinarySubType.BINARY, recipePic.getBytes()));

		recipeService.addRecipe(recipe);
		return ResponseEntity.ok("recipe has been created!");
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/recipes/{id}")
	public Recipe recipe(@PathVariable("id") String id) {
		return recipeService.findRecipeById(id);
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@PutMapping("/recipes/{id}/edit")
	public ResponseEntity<?> editRecipe(@Valid @PathVariable("id") String id,
			@Valid @RequestParam("recipeName") String recipeName,
			@Valid @RequestParam("description") String description,
			@Valid @RequestParam("ingredients") String ingredients,
			@Valid @RequestParam("cookingSteps") String cookingSteps,
			@Valid @RequestParam("recipePic") MultipartFile recipePic) throws IOException {

		// edit current recipe
		Recipe recipe = new Recipe(id, recipeName, description, ingredients, cookingSteps,
				new Binary(BsonBinarySubType.BINARY, recipePic.getBytes()));
		recipeService.updateRecipe(recipe);
		return ResponseEntity.ok("Recipe has ben updated");
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@DeleteMapping("/recipes/{id}/delete")
	public ResponseEntity<?> deleteRecipe(@PathVariable("id") String id) {
		recipeService.deleteRecipe(id);
		return ResponseEntity.ok("Recipe has been deleted");
	}
}
