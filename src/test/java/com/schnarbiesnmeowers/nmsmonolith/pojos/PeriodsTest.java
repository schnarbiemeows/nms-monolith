package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Periods;


import java.util.*;





/**
 * class to test the Periods class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PeriodsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Periods classUnderTest = new Periods();
		classUnderTest.setPeriodId(1);
		classUnderTest.setPeriodTypeId(1);
		classUnderTest.setOneTimeDate(new Date());
		classUnderTest.setDayOfWeek("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		Periods newitem = new Periods(
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