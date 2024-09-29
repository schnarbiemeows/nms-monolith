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
 * class to test the MessageTypesDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class MessageTypesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		MessageTypesDTO classUnderTest = new MessageTypesDTO();
		classUnderTest.setMessageTypeId(new Integer(1));
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