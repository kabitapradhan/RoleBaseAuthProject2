package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> getResourceNotFound(ResourceNotFoundException ex){
		
		ApiResponse api = new ApiResponse();
		api.setMessage(ex.getMessage());
		api.setSuccess(false);
		
		return new ResponseEntity<ApiResponse>(api , HttpStatus.BAD_REQUEST);
		
	}

}
