// package com.recipemanagement.controllers;

//////////// Strech Goal////////////////////:

// //Not Implemented yet

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.ResponseCookie;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.recipemanagement.models.LoginUser;
// import com.recipemanagement.models.User;
// import com.recipemanagement.models.LoginResponse;
// import com.recipemanagement.security.UserDetailsImpl;
// import com.recipemanagement.services.JwtUtils;
// // import com.recipemanagement.security.jwt.JwtUtils;
// import com.recipemanagement.services.UserService;

// import jakarta.servlet.http.HttpSession;
// import jakarta.validation.Valid;

// //acts as authentication controller as well
// // @CrossOrigin(origins = "localhost:5173", maxAge = 3600)
// @RestController
// public class LoginController {

// @Autowired
// UserService userService;
// // for Spring Security
// @Autowired
// AuthenticationManager authenticationManager;

// @Autowired
// PasswordEncoder encoder;

// @Autowired
// JwtUtils jwtUtils;

// @CrossOrigin(origins = "http://localhost:5173")
// @PostMapping("/login")
// public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginUser
// user, BindingResult result) {

// Authentication authentication = authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(user.getEmail(),
// user.getPassword()));

// SecurityContextHolder.getContext().setAuthentication(authentication);
// String jwt = jwtUtils.generateJwtToken(authentication);
// // // gets Pojo UserDetailsImpl after authenticating with database

// // return response details back to frontend, with jwt in cookie and
// // authenticated user details
// User userDetails = userService.findByUserEmail(user.getEmail());
// userService.login(user, result);

// return ResponseEntity.ok(new LoginResponse(
// user.getEmail(),
// jwt));

// }

// // must parse data from request json to User object
// @CrossOrigin(origins = "http://localhost:5173")
// @PostMapping("/register")
// public ResponseEntity<User> register(@Valid @RequestBody User newUser,
// BindingResult result) {

// // User newUser = new User();
// Authentication authentication = authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(newUser.getEmail(),
// newUser.getPassword()));
// SecurityContextHolder.getContext().setAuthentication(authentication);

// // gets Pojo UserDetailsImpl after authenticating with database
// // UserDetailsImpl userDetails = (UserDetailsImpl)
// // authentication.getPrincipal();
// // generate new access token
// // String jwt = jwtUtils.generateJwtToken(authentication);
// // register user
// return ResponseEntity.ok(userService.register(newUser, result));
// }

// }
