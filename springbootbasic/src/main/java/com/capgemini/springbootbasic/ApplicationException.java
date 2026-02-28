package com.capgemini.springbootbasic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // it will handle all the exception 

public class ApplicationException {
	
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<String> handlerException(CustomerNotFound e) {
		return new ResponseEntity<String>(e.getMessage() , HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(Exception.class) // super exception for all the exception it will return for all the exceptions
	public String handleException() {
		return "Exception handle Method" ; 
	}
}
