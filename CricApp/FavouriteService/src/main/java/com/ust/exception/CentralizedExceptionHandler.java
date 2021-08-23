package com.ust.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ExceptionHandler(FavouriteException.class)
	public String Invalidlogin(FavouriteException u) {
    	 return u.getMessage();
     }
}
