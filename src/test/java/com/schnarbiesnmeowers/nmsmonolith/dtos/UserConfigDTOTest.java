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
 * class to test the UserConfigDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class UserConfigDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		UserConfigDTO classUnderTest = new UserConfigDTO();
		classUnderTest.setUsersConfigId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setPropertyKey("a");
		classUnderTest.setPropertyValue("a");
		assertTrue(true);
		UserConfigDTO newitem = new UserConfigDTO(
		classUnderTest.getUsersConfigId(),
		classUnderTest.getUserId(),
		classUnderTest.getPropertyKey(),
		classUnderTest.getPropertyValue());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}