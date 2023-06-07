package com.scaffolding.scaffolding.errorHandler;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestControllerAdvice
public class ErrorHandler {


    @ExceptionHandler({ JdbcSQLIntegrityConstraintViolationException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    private ResponseEntity<Object> handleConstraintViolationException(Exception e) {
        return new ResponseEntity<Object>("El nombre de usuario o dni ya existe",HttpStatus.NOT_ACCEPTABLE);
    }
}
