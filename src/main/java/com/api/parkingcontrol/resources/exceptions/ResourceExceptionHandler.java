package com.api.parkingcontrol.resources.exceptions;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<String> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {


        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(e.getIdentifier().toString());
    }


}
