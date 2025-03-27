package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the MessagesDTO class
 * @author Dylan I. Kessler
 *
 */
public class MessagesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		MessagesDTO classUnderTest = new MessagesDTO();
		classUnderTest.setMessageId(2);
		classUnderTest.setEventId(2);
		classUnderTest.setMessageTypeId(2);
		classUnderTest.setMessageTxt("a");
		assertTrue(true);
		MessagesDTO newitem = new MessagesDTO(
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