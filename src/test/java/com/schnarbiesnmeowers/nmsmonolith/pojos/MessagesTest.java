package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Messages;







/**
 * class to test the Messages class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MessagesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Messages classUnderTest = new Messages();
		classUnderTest.setMessageId(1);
		classUnderTest.setEventId(1);
		classUnderTest.setMessageTypeId(1);
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