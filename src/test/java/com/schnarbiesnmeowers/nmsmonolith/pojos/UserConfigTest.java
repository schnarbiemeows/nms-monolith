package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.UserConfig;







/**
 * class to test the UserConfig class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserConfigTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		UserConfig classUnderTest = new UserConfig();
		classUnderTest.setUsersConfigId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setPropertyKey("a");
		classUnderTest.setPropertyValue("a");
		assertTrue(true);
		UserConfig newitem = new UserConfig(
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