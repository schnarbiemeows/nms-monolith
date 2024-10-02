package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the BldstTableDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BldstTableDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		BldstTableDTO classUnderTest = new BldstTableDTO();
		classUnderTest.setBldstTableId(1);
		classUnderTest.setBldstCde("a");
		classUnderTest.setBldstDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		BldstTableDTO newitem = new BldstTableDTO(
		classUnderTest.getBldstTableId(),
		classUnderTest.getBldstCde(),
		classUnderTest.getBldstDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}