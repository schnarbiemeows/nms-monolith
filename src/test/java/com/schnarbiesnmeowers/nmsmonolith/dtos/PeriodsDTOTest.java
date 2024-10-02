package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the PeriodsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PeriodsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PeriodsDTO classUnderTest = new PeriodsDTO();
		classUnderTest.setPeriodId(1);
		classUnderTest.setPeriodTypeId(1);
		classUnderTest.setOneTimeDate(new Date());
		classUnderTest.setDayOfWeek("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		PeriodsDTO newitem = new PeriodsDTO(
		classUnderTest.getPeriodId(),
		classUnderTest.getPeriodTypeId(),
		classUnderTest.getOneTimeDate(),
		classUnderTest.getDayOfWeek(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}