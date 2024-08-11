package com.example.springboot.exception;

public class BadRequestApplicationException extends IllegalArgumentException{

    public BadRequestApplicationException(String message){
        super(message);
    }
}
