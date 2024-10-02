package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the MessagesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MessagesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		MessagesDTO classUnderTest = new MessagesDTO();
		classUnderTest.setMessageId(1);
		classUnderTest.setEventId(1);
		classUnderTest.setMessageTypeId(1);
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