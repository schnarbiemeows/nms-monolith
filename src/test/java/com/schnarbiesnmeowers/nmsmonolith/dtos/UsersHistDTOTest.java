package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the UsersHistDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsersHistDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		UsersHistDTO classUnderTest = new UsersHistDTO();
		classUnderTest.setUsersHistId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setUsername("a");
		classUnderTest.setEmail("a");
		classUnderTest.setPassword("a");
		classUnderTest.setAge(1);
		classUnderTest.setLstLogdIn(LocalDate.now());
		classUnderTest.setActionTypeId(1);
		classUnderTest.setEvntTmestmp(LocalDate.now());
		classUnderTest.setEvntOperId(1);
		assertTrue(true);
		UsersHistDTO newitem = new UsersHistDTO(
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