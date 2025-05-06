package com.test.test.testwork.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> error(Exception ex)
    {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }

}
