package com.recipemanagement.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ControllerErrorHandler {

	// customized to handle requests to display validations based on request
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(ConstraintViolationException ex) {
		List<String> errors = new ArrayList<String>();
		// loop through all constrained messages
		for (ConstraintViolation<?> error : ex.getConstraintViolations()) {
			errors.add(error.getMessage());
		}
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(),
				HttpStatus.BAD_REQUEST);
	}

	// maps
	private Map<String, List<String>> getErrorsMap(List<String> errors) {
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}

}
