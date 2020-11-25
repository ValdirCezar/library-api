package com.valdir.apilibrary.services.exceptions;

public class ObjectNotFoundExcpetion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExcpetion(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundExcpetion(String message) {
		super(message);
	}

}
