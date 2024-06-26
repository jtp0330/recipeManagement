package com.recipemanagement.repositories;

import java.util.List; 
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.recipemanagement.models.Recipe;
@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId>{
	public List<Recipe> findAll();
	public Optional<Recipe> findById(ObjectId Id);
}