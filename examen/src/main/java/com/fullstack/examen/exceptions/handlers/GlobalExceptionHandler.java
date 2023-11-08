package com.fullstack.examen.exceptions.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fullstack.examen.exceptions.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ArtworkCreationException.class )
	public ProblemDetail handleBookNotFoundException(ArtworkCreationException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Artwork Exception Occurred");
		problemDetail.setType(URI.create("http://examen.com"));
		problemDetail.setProperty("errorCategory", "Artwork");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	
	@ExceptionHandler(artistNotFoundException.class )
	public ProblemDetail handleBookNotFoundException(artistNotFoundException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Artist Exception Occurred");
		problemDetail.setType(URI.create("http://examen.com"));
		problemDetail.setProperty("errorCategory", "Artist");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}




}