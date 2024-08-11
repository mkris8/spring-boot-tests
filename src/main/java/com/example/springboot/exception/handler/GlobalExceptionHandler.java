package com.example.springboot.exception.handler;

import com.example.springboot.exception.BadRequestApplicationException;
import com.example.springboot.exception.InternalServerErrorApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    //handle  exception globally using custom exception Class

    @ExceptionHandler({BadRequestApplicationException.class})
    public ResponseEntity<Object> handleIllegalExceptionGloballyUsingCustomExceptionClass(BadRequestApplicationException bae){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(bae.getMessage());
    }

    @ExceptionHandler({InternalServerErrorApplicationException.class})
    public ResponseEntity<Object>handleInternalException(InternalServerErrorApplicationException ise){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ise.getMessage());
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> handleNPE(NullPointerException npe) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(npe.getMessage());
    }

    // add more @ExceptionHandler methods here for other exceptions
}
