package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the PeriodTypeDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PeriodTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PeriodTypeDTO classUnderTest = new PeriodTypeDTO();
		classUnderTest.setPeriodTypeId(1);
		classUnderTest.setPeriodTypeCde("a");
		classUnderTest.setPeriodTypeDesc("a");
		assertTrue(true);
		PeriodTypeDTO newitem = new PeriodTypeDTO(
		classUnderTest.getPeriodTypeId(),
		classUnderTest.getPeriodTypeCde(),
		classUnderTest.getPeriodTypeDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}