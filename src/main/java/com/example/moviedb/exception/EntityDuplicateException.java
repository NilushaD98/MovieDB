package com.example.moviedb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class EntityDuplicateException extends RuntimeException{

    public EntityDuplicateException(String message) {
        super(message);
    }
}
