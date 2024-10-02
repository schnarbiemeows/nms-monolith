package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.MessageTypes;







/**
 * class to test the MessageTypes class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MessageTypesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		MessageTypes classUnderTest = new MessageTypes();
		classUnderTest.setMessageTypeId(1);
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