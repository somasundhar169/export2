package com.project.employeemanagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String,String>> handleNotFoundExceptions(EmployeeNotFoundException ex){
		Map<String,String> errorMap=new HashMap<>();
	    errorMap.put("Error ", ex.getLocalizedMessage());
	    return new ResponseEntity<>(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity< Map<String,String>> handleMethodArgNotValid(MethodArgumentNotValidException ex){
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->errorMap.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
	}
	
}
