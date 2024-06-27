package com.recipemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipemanagement.models.LoginUser;
import com.recipemanagement.models.User;
import com.recipemanagement.models.UserDetailsResponse;
import com.recipemanagement.security.UserDetailsImpl;
import com.recipemanagement.security.jwt.JwtUtils;
// import com.recipemanagement.security.jwt.JwtUtils;
import com.recipemanagement.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

//acts as authentication controller as well
// @CrossOrigin(origins = "localhost:5173", maxAge = 3600)
@RestController
public class LoginController {

	@Autowired
	UserService userService;
	// for Spring Security
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginUser user, BindingResult result) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getEmail(),
						user.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		// // gets Pojo UserDetailsImpl after authenticating with database
		UserDetailsImpl userDetailsimpl = (UserDetailsImpl) authentication.getPrincipal();

		// return response details back to frontend, with jwt in cookie and
		// authenticated user details
		User userDetails = userService.findByUserEmail(user.getEmail());
		userService.login(user, result);

		return ResponseEntity.ok()
				.header(jwt)
				.body(new UserDetailsResponse(userDetails.getId(),
						userDetails.getFirstName(),
						userDetails.getLastName(),
						userDetails.getEmail()));

	}

	// must parse data from request json to User object
	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {

		// User newUser = new User();
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(newUser.getEmail(),
						newUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// gets Pojo UserDetailsImpl after authenticating with database
		// UserDetailsImpl userDetails = (UserDetailsImpl)
		// authentication.getPrincipal();
		// generate new access token

		// register user
		try {
			userService.register(newUser, result);
		} catch (Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.ok()
				.body(new UserDetailsResponse(newUser.getId(),
						newUser.getFirstName(),
						newUser.getLastName(),
						newUser.getEmail()));
	}

}
