package com.xandeG.workshop.services.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler  {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException err, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
         StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", err.getMessage(), request.getRequestURI());
         return ResponseEntity.status(status).body(error);
    }
}
