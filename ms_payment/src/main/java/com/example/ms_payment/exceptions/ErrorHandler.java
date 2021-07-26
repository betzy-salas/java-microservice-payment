package com.example.ms_payment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandler {

	private List<ErrorInfoDetails> errorInfoDetails = null;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> methodArgumentNotValidException(HttpServletRequest request,
			MethodArgumentNotValidException e) {

		// get spring errors
		BindingResult result = e.getBindingResult();
		List<ObjectError> objectErrors = result.getAllErrors();
		errorInfoDetails = new ArrayList<ErrorInfoDetails>();

		for (ObjectError error : objectErrors) {
			errorInfoDetails.add(getErrorDetail(error));
		}

		ErrorInfo errorInfo = new ErrorInfo("https://monthlymortgagepayme/validation", "Invalid request parameters",
				HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), errorInfoDetails);
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

	}
	
	private ErrorInfoDetails getErrorDetail(ObjectError error) {
		ErrorInfoDetails errorInfoDetail = null;
		
		FieldError tester = null;
		String nameField = "", defaultMessage = "";
		
		if (error instanceof FieldError) {
			tester = ((FieldError) error);
			nameField = tester.getField();
			defaultMessage = tester.getDefaultMessage();
		} else {
			nameField = error.getObjectName();
			defaultMessage = error.getDefaultMessage();
		}
		
		errorInfoDetail = new ErrorInfoDetails(nameField, defaultMessage);
		
		return errorInfoDetail;
		
	}

}
