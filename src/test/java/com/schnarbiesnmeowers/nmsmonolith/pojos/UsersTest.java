package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the Users class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class UsersTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Users classUnderTest = new Users();
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setUsername("a");
		classUnderTest.setEmail("a");
		classUnderTest.setPhone("a");
		classUnderTest.setPassword("a");
		classUnderTest.setAge(new Integer(1));
		classUnderTest.setLstLogdIn(new Date());
		assertTrue(true);
		Users newitem = new Users(
		classUnderTest.getUserId(),
		classUnderTest.getUsername(),
		classUnderTest.getEmail(),
		classUnderTest.getPhone(),
		classUnderTest.getPassword(),
		classUnderTest.getAge(),
		classUnderTest.getLstLogdIn());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}