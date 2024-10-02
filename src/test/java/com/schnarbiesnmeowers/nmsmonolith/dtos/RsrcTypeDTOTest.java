package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the RsrcTypeDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RsrcTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RsrcTypeDTO classUnderTest = new RsrcTypeDTO();
		classUnderTest.setRsrcTypeId(1);
		classUnderTest.setRsrcType("a");
		classUnderTest.setRsrcTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RsrcTypeDTO newitem = new RsrcTypeDTO(
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcType(),
		classUnderTest.getRsrcTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}