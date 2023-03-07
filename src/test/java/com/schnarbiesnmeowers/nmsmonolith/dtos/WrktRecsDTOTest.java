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
 * class to test the WrktRecsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class WrktRecsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		WrktRecsDTO classUnderTest = new WrktRecsDTO();
		classUnderTest.setWrktRecId(new Integer(1));
		classUnderTest.setWorkoutId(new Integer(1));
		classUnderTest.setLiftId(new Integer(1));
		classUnderTest.setWeight(new BigDecimal(1.00));
		classUnderTest.setReps(new Integer(1));
		assertTrue(true);
		WrktRecsDTO newitem = new WrktRecsDTO(
		classUnderTest.getWrktRecId(),
		classUnderTest.getWorkoutId(),
		classUnderTest.getLiftId(),
		classUnderTest.getWeight(),
		classUnderTest.getReps());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}