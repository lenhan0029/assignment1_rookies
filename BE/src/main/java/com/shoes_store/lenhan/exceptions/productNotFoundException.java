package com.shoes_store.lenhan.exceptions;

public class productNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public productNotFoundException() {
		super();
	}

	public productNotFoundException(String message) {
		super(message);
	}

	public productNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
