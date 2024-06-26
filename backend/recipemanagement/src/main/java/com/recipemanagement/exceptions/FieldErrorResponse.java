package com.recipemanagement.exceptions;

import java.util.List;

public class FieldErrorResponse {
	private List<CustomFieldError> fieldErrors;
	
	public FieldErrorResponse() {
		
	}
	
	public List<CustomFieldError> getfieldErrors() {
		return this.fieldErrors;
	}
	
	public void setFieldErrors(List<CustomFieldError> fieldErrors)
	{
		this.fieldErrors = fieldErrors;
	}
}
