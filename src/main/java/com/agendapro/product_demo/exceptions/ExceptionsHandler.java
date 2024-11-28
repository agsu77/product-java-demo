package com.agendapro.product_demo.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.agendapro.product_demo.dto.ErrorDto;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = ProductoNotFound.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	private ResponseEntity<Object> handleProductNotFound(RuntimeException e, WebRequest req) {
		ErrorDto error = new ErrorDto(-1, e.getMessage());
		return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
	}

}
