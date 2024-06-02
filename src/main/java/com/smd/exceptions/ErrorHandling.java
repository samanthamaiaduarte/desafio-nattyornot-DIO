package com.smd.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandling {
    
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ExceptionMessage> handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
		ExceptionMessage obj = new ExceptionMessage(LocalDateTime.now(), HttpStatus.BAD_REQUEST.name(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(obj);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handleUserNotFoundException(UserNotFoundException e) {
		ExceptionMessage obj = new ExceptionMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
    }
    
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ExceptionMessage> handleUnexpected(Throwable exception) {
		ExceptionMessage obj = new ExceptionMessage(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.name(), "Unexpected server error");
		return ResponseEntity.internalServerError().body(obj);
	}    
}