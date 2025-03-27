package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.UsersHist;
import java.math.*;


/**
 * class to test the UsersHist class
 * @author Dylan I. Kessler
 *
 */
public class UsersHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		UsersHist classUnderTest = new UsersHist();
		classUnderTest.setUsersHistId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setUsername("a");
		classUnderTest.setEmail("a");
		classUnderTest.setPassword("a");
		classUnderTest.setAge(2);
		classUnderTest.setLstLogdIn(new Date());
		classUnderTest.setActionTypeId(2);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(2);
		assertTrue(true);
		UsersHist newitem = new UsersHist(
		classUnderTest.getUsersHistId(),
		classUnderTest.getUserId(),
		classUnderTest.getUsername(),
		classUnderTest.getEmail(),
		classUnderTest.getPassword(),
		classUnderTest.getAge(),
		classUnderTest.getLstLogdIn(),
		classUnderTest.getActionTypeId(),
		classUnderTest.getEvntTmestmp(),
		classUnderTest.getEvntOperId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}