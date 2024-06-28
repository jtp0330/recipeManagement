package com.recipemanagement.models;

//for passing details back to frontend
public class UserDetailsResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private final String token;
    // private List<Recipe> recipes;

    public UserDetailsResponse() {
        this.token = "";
    }

    // public UserDetailsResponse(ObjectId id, String firstName, String lastName,
    // String email, List<Recipe> recipes) {
    // this.id = id;
    // this.firstName = firstName;
    // this.lastName = lastName;
    // this.email = email;
    // this.recipes = recipes;
    // }

    public UserDetailsResponse(String id, String firstName, String lastName, String email, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.token = token;
        // this.recipes = recipes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getToken() {
        return token;
    }

    // public List<Recipe> getRecipeIds() {
    // return recipes;
    // }

    // public void setRecipeIds(List<Recipe> recipes) {
    // this.recipes = recipes;
    // }
}
