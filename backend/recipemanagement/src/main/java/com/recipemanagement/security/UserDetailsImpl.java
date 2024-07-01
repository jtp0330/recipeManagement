// package com.recipemanagement.security;

// import java.util.Collection;
// import java.util.List;

// import org.bson.types.ObjectId;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.recipemanagement.models.Recipe;
// import com.recipemanagement.models.User;

// //requires this class to extract custom fields after authenticating with session, cors, and spring security

// public class UserDetailsImpl implements UserDetails {

// 	private static final long serialVersionUID = 1L;

// 	// fields required after authentication
// 	private String id;
// 	private String firstName;
// 	private String lastName;
// 	private String email;
// 	@JsonIgnore
// 	private String password;
// 	private List<Recipe> recipes;

// 	public UserDetailsImpl(String id, String firstName, String lastName, String email, String password) {
// 		this.id = id;
// 		this.firstName = firstName;
// 		this.lastName = lastName;
// 		this.email = email;
// 		this.password = password;
// 	}

// 	public static UserDetailsImpl build(User user) {
// 		return new UserDetailsImpl(
// 				user.getId(),
// 				user.getFirstName(),
// 				user.getLastName(),
// 				user.getEmail(),
// 				user.getPassword());
// 	}

// 	public String getId() {
// 		return id;
// 	}

// 	public void setId(String id) {
// 		this.id = id;
// 	}

// 	public String getFirstName() {
// 		return firstName;
// 	}

// 	public void setFirstName(String firstName) {
// 		this.firstName = firstName;
// 	}

// 	public String getLastName() {
// 		return lastName;
// 	}

// 	public void setLastName(String lastName) {
// 		this.lastName = lastName;
// 	}

// 	public String getEmail() {
// 		return email;
// 	}

// 	public void setEmail(String email) {
// 		this.email = email;
// 	}

// 	public List<Recipe> getRecipes() {
// 		return recipes;
// 	}

// 	public void setRecipes(List<Recipe> recipes) {
// 		this.recipes = recipes;
// 	}

// 	// in case user logged in past expected time
// 	@Override
// 	public boolean isAccountNonExpired() {
// 		return true;
// 	}

// 	// should not be necessary as we are not using roles in application, may need to
// 	// implement per
// 	// spring security restraints
// 	@Override
// 	public Collection<? extends GrantedAuthority> getAuthorities() {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// 	@Override
// 	public String getPassword() {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// 	@Override
// 	public String getUsername() {
// 		// TODO Auto-generated method stub
// 		return null;
// 	}

// }