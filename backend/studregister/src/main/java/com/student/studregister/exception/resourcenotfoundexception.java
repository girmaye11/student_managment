package com.student.studregister.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class resourcenotfoundexception extends RuntimeException{
    private static final long seriaLVersionUID=1L;
    public resourcenotfoundexception(String message){
        super(message);

    }
}
