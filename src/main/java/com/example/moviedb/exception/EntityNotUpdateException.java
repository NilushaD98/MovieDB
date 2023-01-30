package com.example.moviedb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_MODIFIED)
public class EntityNotUpdateException extends RuntimeException{
    public EntityNotUpdateException(String message) {
        super(message);
    }
}
