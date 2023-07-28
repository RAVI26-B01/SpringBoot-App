package com.springApp.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springApp.Exception.UserNotFoundException;

@RestControllerAdvice
public class EntityExceptionHandler {

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleEntityException(MethodArgumentNotValidException ex){
		Map<String,String> errMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errMap.put(error.getField(),error.getDefaultMessage());
		});
		return errMap;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> employeeFindException(UserNotFoundException ex){
		Map<String,String> errMap = new HashMap<>();
		errMap.put("Message", ex.getMessage());
		return errMap;
	}
}
