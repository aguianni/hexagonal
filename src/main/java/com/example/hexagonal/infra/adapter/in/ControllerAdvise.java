package com.example.hexagonal.infra.adapter.in;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {

    Logger logger = LoggerFactory.getLogger(ControllerAdvise.class);

    @ExceptionHandler(value= {Exception.class, RuntimeException.class })
    protected ResponseEntity<String> handleConflict(Throwable ex) {
        logger.info(ex.getMessage());
        String bodyOfResponse = "Bad Request: " + ex.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.BAD_REQUEST);
    }
}
