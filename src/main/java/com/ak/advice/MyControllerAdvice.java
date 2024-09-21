package com.ak.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ak.exception.InvalidMovieIdException;
import com.ak.exception.InvalidTicketIdException;
import com.ak.exception.MovieNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(InvalidMovieIdException.class)
	public ResponseEntity invalidMovieIdExceptionHandler(InvalidMovieIdException e) {
		return ResponseEntity.badRequest().build();
	}

	@ExceptionHandler(InvalidTicketIdException.class)
	public ResponseEntity invalidTicketIdExceptionHandler(InvalidTicketIdException e) {
		return ResponseEntity.badRequest().build();
	}
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity movieNotFoundExceptionHandler(MovieNotFoundException e) {
		return ResponseEntity.badRequest().build();
	}

}
