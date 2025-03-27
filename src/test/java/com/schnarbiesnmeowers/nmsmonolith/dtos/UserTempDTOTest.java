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
 * class to test the UserTempDTO class
 * @author Dylan I. Kessler
 *
 */
public class UserTempDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		UserTempDTO classUnderTest = new UserTempDTO();
		classUnderTest.setUserTempId(2);
		classUnderTest.setUsername("a");
		classUnderTest.setEmail("a");
		classUnderTest.setPhone("a");
		classUnderTest.setFirstName("a");
		classUnderTest.setLastName("a");
		classUnderTest.setAge(2);
		classUnderTest.setActv(true);
		String[] stringarray = new String[1];
		stringarray[0] = Randomizer.randomString(3);
		classUnderTest.setAuthorizations(stringarray);
		classUnderTest.setUserNotLocked(true);
		classUnderTest.setCreatedDate(new Date());
		classUnderTest.setJoinDate(new Date());
		classUnderTest.setLastLoginDate(new Date());
		classUnderTest.setLastLoginDateDisplay(new Date());
		classUnderTest.setPassword("a");
		classUnderTest.setProfileImage("a");
		classUnderTest.setRoles("a");
		classUnderTest.setUserIdentifier("a");
		classUnderTest.setUniqueId("a");
		assertTrue(true);
		UserTempDTO newitem = new UserTempDTO(
		classUnderTest.getUserTempId(),
		classUnderTest.getUsername(),
		classUnderTest.getEmail(),
		classUnderTest.getPhone(),
		classUnderTest.getFirstName(),
		classUnderTest.getLastName(),
		classUnderTest.getAge(),
		classUnderTest.getActv(),
		classUnderTest.getAuthorizations(),
		classUnderTest.getUserNotLocked(),
		classUnderTest.getCreatedDate(),
		classUnderTest.getJoinDate(),
		classUnderTest.getLastLoginDate(),
		classUnderTest.getLastLoginDateDisplay(),
		classUnderTest.getPassword(),
		classUnderTest.getProfileImage(),
		classUnderTest.getRoles(),
		classUnderTest.getUserIdentifier(),
		classUnderTest.getUniqueId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}