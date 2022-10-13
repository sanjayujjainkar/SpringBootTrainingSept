package com.caradmin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
		return new ResponseEntity<>(exception.getResourceName()
				+ " with " + exception.getFieldName()
				+ " : " + exception.getFieldValue()
				+ " NOT FOUND\nTry with valid id.", HttpStatus.NOT_FOUND);
		
	}

}
