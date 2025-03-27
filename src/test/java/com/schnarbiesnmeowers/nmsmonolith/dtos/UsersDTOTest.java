package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the UsersDTO class
 * @author Dylan I. Kessler
 *
 */
public class UsersDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		UsersDTO classUnderTest = new UsersDTO();
		classUnderTest.setUserId(2);
		classUnderTest.setUsername("a");
		classUnderTest.setEmail("a");
		classUnderTest.setPassword("a");
		classUnderTest.setAge(2);
		classUnderTest.setLstLogdIn(new Date());
		classUnderTest.setPhone("a");
		classUnderTest.setActv(true);
		String[] stringarray = new String[1];
		stringarray[0] = Randomizer.randomString(3);
		classUnderTest.setAuthorizations(stringarray);
		classUnderTest.setFirstName("a");
		classUnderTest.setLastName("a");
		classUnderTest.setUserNotLocked(true);
		classUnderTest.setJoinDate(new Date());
		classUnderTest.setLastLoginDateDisplay(new Date());
		classUnderTest.setProfileImage("a");
		classUnderTest.setRoles("a");
		classUnderTest.setUserIdentifier("a");
		assertTrue(true);
		UsersDTO newitem = new UsersDTO(
		classUnderTest.getUserId(),
		classUnderTest.getUsername(),
		classUnderTest.getEmail(),
		classUnderTest.getPassword(),
		classUnderTest.getAge(),
		classUnderTest.getLstLogdIn(),
		classUnderTest.getPhone(),
		classUnderTest.getActv(),
		classUnderTest.getAuthorizations(),
		classUnderTest.getFirstName(),
		classUnderTest.getLastName(),
		classUnderTest.getUserNotLocked(),
		classUnderTest.getJoinDate(),
		classUnderTest.getLastLoginDateDisplay(),
		classUnderTest.getProfileImage(),
		classUnderTest.getRoles(),
		classUnderTest.getUserIdentifier());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}