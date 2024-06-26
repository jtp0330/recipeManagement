package com.recipemanagement.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

//for passing details back to frontend
public class UserDetailsResponse {

    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Recipe> recipes;

    public UserDetailsResponse() {
    }

    public UserDetailsResponse(ObjectId id, String firstName, String lastName, String email, List<Recipe> recipes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.recipes = recipes;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public List<Recipe> getRecipeIds() {
        return recipes;
    }

    public void setRecipeIds(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
