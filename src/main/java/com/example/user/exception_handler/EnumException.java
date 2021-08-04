package com.example.user.exception_handler;

import com.example.user.entity.State;

public class EnumException extends RuntimeException {
	 private Integer code;

	    public EnumException(State state) {
	        super();
	    }
}
