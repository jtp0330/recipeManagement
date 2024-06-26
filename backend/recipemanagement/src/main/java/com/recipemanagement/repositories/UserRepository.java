package com.recipemanagement.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.recipemanagement.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
	public Optional<User> findById(ObjectId Id);

	public Optional<User> findByEmail(String email);

}
