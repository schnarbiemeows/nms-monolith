package com.schnarbiesnmeowers.nmsmonolith.exceptions;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * class to test the ExceptionResponse class
 * @author Dylan I. Kessler
 *
 */

public class ExceptionResponseTest {

	/**
	 * test the constructor and the getters
	 */
	@Test
	public void testClass() {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "message", "details");
		assertNotNull(exceptionResponse.getTimestamp());
		assertNotNull(exceptionResponse.getMessage());
		assertNotNull(exceptionResponse.getDetails());
	}
}