package com.capp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(MoedaNotFoundException.class)
	public ResponseEntity<ErrorMessage> moedaNotFound(MoedaNotFoundException p_exception, WebRequest p_request) {
		ErrorMessage message = new ErrorMessage(
				HttpStatus.NOT_FOUND.value(),
				new Date(),
				p_exception.getMessage(),
				p_request.getDescription( false )
				);
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}

}
