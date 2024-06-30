package com.recipemanagement.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class ControllerErrorHandler {

	// @ExceptionHandler(MethodArgumentNotValidException.class)
	// protected ResponseEntity<Object>
	// handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	// HttpHeaders headers,
	// HttpStatus status, WebRequest request) {

	// FieldErrorResponse fieldErrorResponse = new FieldErrorResponse();

	// List<CustomFieldError> fieldErrors = new ArrayList<>();
	// ex.getBindingResult().getAllErrors().forEach((error) -> {
	// CustomFieldError fieldError = new CustomFieldError();
	// fieldError.setField(((FieldError) error).getField());
	// fieldError.setMessage(error.getDefaultMessage());
	// System.out.println(error.getCode());
	// fieldErrors.add(fieldError);
	// });

	// fieldErrorResponse.setFieldErrors(fieldErrors);
	// return new ResponseEntity<>(fieldErrorResponse, status);
	// }

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors()
				.stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	private Map<String, List<String>> getErrorsMap(List<String> errors) {
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}
}
