package com.example.user.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class UserException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException(String msg) {
		super(msg);
		
	}
}
