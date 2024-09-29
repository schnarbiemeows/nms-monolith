package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the PeriodTypeDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class PeriodTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PeriodTypeDTO classUnderTest = new PeriodTypeDTO();
		classUnderTest.setPeriodTypeId(new Integer(1));
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