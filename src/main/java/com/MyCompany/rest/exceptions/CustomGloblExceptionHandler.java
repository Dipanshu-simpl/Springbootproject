package com.MyCompany.rest.exceptions;

import java.sql.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGloblExceptionHandler extends ResponseEntityExceptionHandler{

	
	// MethodArgumentNotValidException.
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails custom=new CustomErrorDetails(new Date(0),
				"From Method argumentnotvalid exception",ex.getMessage());
		
		return new ResponseEntity<Object>(custom,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		pageNotFoundLogger.warn(ex.getMessage());

		    CustomErrorDetails customerror=new CustomErrorDetails(new Date(0),
		    		"From HttpRequestMethodNotSupportedException",ex.getMessage());
		    
		    return new ResponseEntity<Object>(customerror,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex,
			WebRequest request)
	{
		
		CustomErrorDetails custom=new CustomErrorDetails(new Date(0),ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<Object>(custom,HttpStatus.NOT_FOUND);
		
	}
	
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,WebRequest request)
    {
    	CustomErrorDetails custom=new CustomErrorDetails(new Date(0),ex.getMessage(),
    			request.getDescription(false));
    	
    	return new ResponseEntity<Object>(custom,HttpStatus.BAD_REQUEST);    	
    }
}
