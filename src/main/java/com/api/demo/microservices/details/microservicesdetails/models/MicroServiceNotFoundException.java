package com.api.demo.microservices.details.microservicesdetails.models;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MicroServiceNotFoundException extends RuntimeException {

	public MicroServiceNotFoundException() {
		
	}
	
	public MicroServiceNotFoundException(String message) {
		super(message);
	}
}
