package com.schnarbiesnmeowers.nmsmonolith.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumberTooBigException extends RuntimeException{
    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");


    public NumberTooBigException(String message) {
        super(message);
    }
}
