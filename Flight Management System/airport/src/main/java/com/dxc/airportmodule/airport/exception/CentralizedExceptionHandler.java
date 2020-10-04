package com.dxc.airportmodule.airport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ExceptionHandler(AirportNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleAirportNotFound(AirportNotFoundException e) {
		System.out.println("inside hanldeAirportNotFoundException");
		return e.getMessage();

	}

	@ExceptionHandler(InvalidArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleInvalidArgumentException(InvalidArgumentException e) {
		System.out.println("inside handleInvalidArgumentException");
		return e.getMessage();
	}
}
