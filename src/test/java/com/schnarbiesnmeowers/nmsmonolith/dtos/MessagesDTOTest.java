package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the MessagesDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class MessagesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		MessagesDTO classUnderTest = new MessagesDTO();
		classUnderTest.setMessageId(new Integer(1));
		classUnderTest.setEventId(new Integer(1));
		classUnderTest.setMessageTypeId(new Integer(1));
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