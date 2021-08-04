package com.example.user.exception_handler;

import org.springframework.core.NestedRuntimeException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Object> handleUserException
	(UserException ex,WebRequest req) throws Exception{
		ExceptionResponse exception = 
				new ExceptionResponse(ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<Object>(exception,HttpStatus.BAD_REQUEST);
		
	}
	
	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<Object>
	 * handleInvalidEnumException (HttpMessageNotReadableException ex,HandlerMethod
	 * handlerMethod,WebRequest req){
	 * 
	 * InvalidEnumException exception = (InvalidEnumException)
	 * ((NestedRuntimeException) ex).getMostSpecificCause();
	 * 
	 * exception.setEnumName("invalid"); exception.setEnumValue("invalid");
	 * 
	 * return new ResponseEntity<Object>(exception,HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exception = 
				new ExceptionResponse(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(exception,HttpStatus.BAD_REQUEST);
		
	
	}
	
	
	
}
