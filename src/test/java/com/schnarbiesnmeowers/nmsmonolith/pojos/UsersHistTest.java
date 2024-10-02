package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.UsersHist;


import java.util.*;





/**
 * class to test the UsersHist class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UsersHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		UsersHist classUnderTest = new UsersHist();
		classUnderTest.setUsersHistId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setUsername("a");
		classUnderTest.setEmail("a");
		classUnderTest.setPassword("a");
		classUnderTest.setAge(1);
		classUnderTest.setLstLogdIn(new Date());
		classUnderTest.setActionTypeId(1);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(1);
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