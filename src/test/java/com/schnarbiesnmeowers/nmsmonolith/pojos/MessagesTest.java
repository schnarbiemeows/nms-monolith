package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Messages;
import java.math.*;


/**
 * class to test the Messages class
 * @author Dylan I. Kessler
 *
 */
public class MessagesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Messages classUnderTest = new Messages();
		classUnderTest.setMessageId(2);
		classUnderTest.setEventId(2);
		classUnderTest.setMessageTypeId(2);
		classUnderTest.setMessageTxt("a");
		assertTrue(true);
		Messages newitem = new Messages(
		classUnderTest.getMessageId(),
		classUnderTest.getEventId(),
		classUnderTest.getMessageTypeId(),
		classUnderTest.getMessageTxt());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}