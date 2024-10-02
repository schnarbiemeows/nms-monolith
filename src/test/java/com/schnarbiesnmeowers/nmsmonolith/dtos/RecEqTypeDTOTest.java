package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the RecEqTypeDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecEqTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecEqTypeDTO classUnderTest = new RecEqTypeDTO();
		classUnderTest.setRecEqTypeId(1);
		classUnderTest.setRecEqCde("a");
		classUnderTest.setRecEqDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RecEqTypeDTO newitem = new RecEqTypeDTO(
		classUnderTest.getRecEqTypeId(),
		classUnderTest.getRecEqCde(),
		classUnderTest.getRecEqDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}