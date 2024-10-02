package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the ResourcesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ResourcesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ResourcesDTO classUnderTest = new ResourcesDTO();
		classUnderTest.setRsrcId(1);
		classUnderTest.setRsrcTypeId(1);
		classUnderTest.setRsrcDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		ResourcesDTO newitem = new ResourcesDTO(
		classUnderTest.getRsrcId(),
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}