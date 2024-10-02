package com.schnarbiesnmeowers.nmsmonolith.exceptions;


import java.util.Date;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;


/**
 * class to test the ExceptionResponse class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ExceptionResponseTest {

	/**
	 * test the constructor and the getters
	 */
	//@Test
	public void testClass() {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "message", "details");
		assertNotNull(exceptionResponse.getTimestamp());
		assertNotNull(exceptionResponse.getMessage());
		assertNotNull(exceptionResponse.getDetails());
	}
}