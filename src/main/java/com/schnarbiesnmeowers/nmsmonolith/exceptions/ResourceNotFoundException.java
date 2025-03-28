package com.schnarbiesnmeowers.nmsmonolith.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * class for the 404 exception
 * @author Dylan I. Kessler
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	public ResourceNotFoundException(String message) {
		super(message);
	}
}