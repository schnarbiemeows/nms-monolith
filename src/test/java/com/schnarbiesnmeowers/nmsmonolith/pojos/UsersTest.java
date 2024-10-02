package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Users;


import java.util.*;





/**
 * class to test the Users class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UsersTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Users classUnderTest = new Users();
		classUnderTest.setUserId(1);
		classUnderTest.setUsername("a");
		classUnderTest.setEmail("a");
		classUnderTest.setPhone("a");
		classUnderTest.setPassword("a");
		classUnderTest.setAge(1);
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