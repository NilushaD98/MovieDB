package com.example.moviedb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class EnumTypeWrongException extends RuntimeException{

    public EnumTypeWrongException(String message){
        super(message);
    }
}
