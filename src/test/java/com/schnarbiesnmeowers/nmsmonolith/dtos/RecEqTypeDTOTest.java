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
 * class to test the RecEqTypeDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecEqTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecEqTypeDTO classUnderTest = new RecEqTypeDTO();
		classUnderTest.setRecEqTypeId(new Integer(1));
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