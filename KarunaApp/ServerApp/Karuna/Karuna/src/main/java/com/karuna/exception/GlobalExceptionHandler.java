package com.karuna.exception;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.karuna.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<FieldError> list = e.getFieldErrors();
		Map<String, String> map = list.stream() // Stream<FieldError>
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(RuntimeException e) {
		return ResponseEntity.
				status(HttpStatus.NOT_FOUND).
				body(new ApiResponse(e.getMessage()));
		
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<?> handleUserAlreadyExistException(RuntimeException e) {
		return ResponseEntity.
				status(HttpStatus.NOT_ACCEPTABLE).
				body(new ApiResponse(e.getMessage()));
		
	}
	

	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
		
		return ResponseEntity.
				status(HttpStatus.INTERNAL_SERVER_ERROR).
				body(new ApiResponse(e.getMessage()));
		
	}
	
		@ExceptionHandler(Exception.class)
		public ResponseEntity<?> handleException(Exception e) {
			
			return ResponseEntity.
					status(HttpStatus.INTERNAL_SERVER_ERROR).
					body(new ApiResponse(e.getMessage()));
			
		}
		

}
