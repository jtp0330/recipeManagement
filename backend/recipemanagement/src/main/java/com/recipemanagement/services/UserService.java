// package com.recipemanagement.services;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.bcrypt.BCrypt;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.validation.BindingResult;

// import com.recipemanagement.models.LoginUser;
// import com.recipemanagement.models.User;
// import com.recipemanagement.repositories.UserRepository;

// @Service
// public class UserService {

// @Autowired
// UserRepository userRepository;

// @Autowired
// PasswordEncoder passwordEncoder;

// @Autowired
// AuthenticationManager authenticationManager;

// public User register(User newUser, BindingResult result) {
// // TO-DO - Reject values or register if no errors:
// String passwordEntered = newUser.getPassword();
// Optional<User> potentialUser =
// userRepository.findByEmail(newUser.getEmail());

// // Reject if email is taken (present in database)
// if (potentialUser.isPresent()) {
// result.rejectValue("email", "Matches", "An account already exists, please
// sign in!");
// return null;
// }
// // Reject if password doesn't match confirmation
// if (!passwordEntered.equals(newUser.getConfirmPassword())) {
// result.rejectValue("confirm", "Matches", "The Confirm Password must match
// Password!");
// }
// // Return null if result has errors
// if (result.hasErrors()) {
// return null;
// }
// // Hash and set password, save user to database
// String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
// newUser.setPassword(hashed);
// return userRepository.save(newUser);

// }

// public User login(LoginUser newLogin, BindingResult result) {
// // TO-DO - Reject values:
// // Find user in the DB by email
// Optional<User> potentialUser =
// userRepository.findByEmail(newLogin.getEmail());

// // Reject if NOT present
// if (!potentialUser.isPresent()) {
// result.rejectValue("email", "Matches", "User Not Found Provided Email!");
// return null;
// }

// User userData = potentialUser.get();
// // Reject if BCrypt password match fails
// if (!BCrypt.checkpw(newLogin.getPassword(), userData.getPassword())) {
// result.rejectValue("password", "Matches", "Invalid Password!");
// }
// // Return null if result has errors

// if (result.hasErrors()) {
// return null;
// }
// // Otherwise, authenticate user token
// authenticationManager
// .authenticate(new UsernamePasswordAuthenticationToken(userData.getEmail(),
// userData.getPassword()));

// return userData;
// }

// public User findByUserId(String userId) {
// Optional<User> potentialUser = userRepository.findById(userId);

// if (potentialUser.isPresent()) {
// return potentialUser.get();
// } else
// return null;
// }

// public User findByUserEmail(String email) {
// Optional<User> potentialUser = userRepository.findByEmail(email);

// if (potentialUser.isPresent()) {
// return potentialUser.get();
// } else
// return null;
// }
// }
