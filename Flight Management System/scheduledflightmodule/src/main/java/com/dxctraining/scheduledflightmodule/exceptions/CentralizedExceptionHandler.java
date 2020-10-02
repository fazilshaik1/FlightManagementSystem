package com.dxctraining.scheduledflightmodule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleScheduledFlightNotFound(ScheduledFlightNotFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(InvalidArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleIvalidArgument(InvalidArgumentException e) {
		return e.getMessage();
	}

}
