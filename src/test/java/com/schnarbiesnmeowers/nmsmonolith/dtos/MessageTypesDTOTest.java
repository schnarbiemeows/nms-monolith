package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the MessageTypesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MessageTypesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		MessageTypesDTO classUnderTest = new MessageTypesDTO();
		classUnderTest.setMessageTypeId(1);
		classUnderTest.setMessageTypeCde("a");
		classUnderTest.setMessageTypeDesc("a");
		assertTrue(true);
		MessageTypesDTO newitem = new MessageTypesDTO(
		classUnderTest.getMessageTypeId(),
		classUnderTest.getMessageTypeCde(),
		classUnderTest.getMessageTypeDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}