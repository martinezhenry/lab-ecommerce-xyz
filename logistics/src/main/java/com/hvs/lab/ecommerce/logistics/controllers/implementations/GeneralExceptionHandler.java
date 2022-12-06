package com.hvs.lab.ecommerce.logistics.controllers.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<Error> exceptionHandlerTimeout(TimeoutException timeoutException){
        var error = new Error();
        error.setStatus(500);
        error.setTimestamp(LocalDateTime.now());
        error.setMessage(timeoutException.getMessage());
        return ResponseEntity.status(500).body(error);
    }

}
