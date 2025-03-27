package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.MessageTypes;
import java.math.*;


/**
 * class to test the MessageTypes class
 * @author Dylan I. Kessler
 *
 */
public class MessageTypesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		MessageTypes classUnderTest = new MessageTypes();
		classUnderTest.setMessageTypeId(2);
		classUnderTest.setMessageTypeCde("a");
		classUnderTest.setMessageTypeDesc("a");
		assertTrue(true);
		MessageTypes newitem = new MessageTypes(
		classUnderTest.getMessageTypeId(),
		classUnderTest.getMessageTypeCde(),
		classUnderTest.getMessageTypeDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}