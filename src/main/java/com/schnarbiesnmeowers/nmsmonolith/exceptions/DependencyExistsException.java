package com.schnarbiesnmeowers.nmsmonolith.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class DependencyExistsException extends RuntimeException {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    public DependencyExistsException(String message) {
        super(message);
    }
}
