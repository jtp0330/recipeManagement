package com.recipemanagement.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipemanagement.models.Recipe;
import com.recipemanagement.repositories.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	RecipeRepository recipeRepo;

	public List<Recipe> findAll() {
		return recipeRepo.findAll();
	}

	public Recipe findRecipeById(ObjectId id) {
		Optional<Recipe> recipe = recipeRepo.findById(id);
		return recipe.get();
	}

	public Recipe addRecipe(Recipe recipe) {
		return recipeRepo.save(recipe);

	}

	public Recipe updateRecipe(Recipe recipe) {
		return recipeRepo.save(recipe);
	}

	public void deleteRecipe(ObjectId id) {
		recipeRepo.deleteById(id);
	}
}
