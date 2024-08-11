package com.example.springboot.exception;

public class InternalServerErrorApplicationException extends RuntimeException {
    public InternalServerErrorApplicationException(String message) {
        super(message);
    }
}
