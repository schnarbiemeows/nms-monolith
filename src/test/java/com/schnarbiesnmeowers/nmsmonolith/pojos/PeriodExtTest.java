package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.PeriodExt;


import java.util.*;





/**
 * class to test the PeriodExt class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PeriodExtTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PeriodExt classUnderTest = new PeriodExt();
		classUnderTest.setPeriodExtId(1);
		classUnderTest.setPeriodId(1);
		classUnderTest.setSpecificDate(new Date());
		classUnderTest.setSpecificTime(new java.sql.Time(1000));
		assertTrue(true);
		PeriodExt newitem = new PeriodExt(
		classUnderTest.getPeriodExtId(),
		classUnderTest.getPeriodId(),
		classUnderTest.getSpecificDate(),
		classUnderTest.getSpecificTime());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}