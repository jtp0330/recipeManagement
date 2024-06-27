package com.recipemanagement.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipemanagement.models.Recipe;
import com.recipemanagement.services.RecipeService;
import com.recipemanagement.services.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	@Autowired
	UserService userService;

	// template to interact with MongoDB Connection
	MongoTemplate mongoTemplate = null;

	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/recipes")
	public List<Recipe> recipeHome() {
		return recipeService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("/recipes/add")
	public ResponseEntity<?> addRecipe(@Valid @RequestBody Recipe recipe,
			BindingResult result,
			Model model,
			HttpSession session) {

		// add recipe
		recipeService.addRecipe(recipe);
		return ResponseEntity.ok("New Recipe has been created");
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/recipes/{id}")
	public Recipe recipe(@PathVariable("id") String id) {
		return recipeService.findRecipeById(id);
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@PutMapping("/recipes/{id}/edit")
	public ResponseEntity<?> editRecipe(@Valid @PathVariable("id") String id, @RequestBody Recipe recipe,
			BindingResult result,
			Model model,
			HttpSession session) {

		// edit current recipe
		recipe.setId(id);
		Recipe r = recipeService.updateRecipe(recipe);
		return ResponseEntity.ok("Recipe has ben updated");
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@DeleteMapping("/recipes/{id}/delete")
	public ResponseEntity<?> deleteRecipe(@PathVariable("id") String id) {
		recipeService.deleteRecipe(id);
		return ResponseEntity.ok("Recipe has been deleted");
	}
}
