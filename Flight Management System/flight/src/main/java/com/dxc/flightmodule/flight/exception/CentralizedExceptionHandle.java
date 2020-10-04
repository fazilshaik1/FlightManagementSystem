package com.dxc.flightmodule.flight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandle {

	@ExceptionHandler(FlightNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleFlightNotFoundException(FlightNotFoundException e) {
		System.out.println("inside handleNotFoundException");
		return e.getMessage();
	}

	@ExceptionHandler(InvalidArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleInvalidArgumentException(InvalidArgumentException e) {
		System.out.println("inside handleInvalidArgumentException");
		return e.getMessage();
	}
}
