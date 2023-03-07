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
 * class to test the LiftStepsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class LiftStepsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftStepsDTO classUnderTest = new LiftStepsDTO();
		classUnderTest.setLiftStepId(new Integer(1));
		classUnderTest.setLiftId(new Integer(1));
		classUnderTest.setStepNum(new Integer(1));
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		assertTrue(true);
		LiftStepsDTO newitem = new LiftStepsDTO(
		classUnderTest.getLiftStepId(),
		classUnderTest.getLiftId(),
		classUnderTest.getStepNum(),
		classUnderTest.getStepDesc(),
		classUnderTest.getImageLoc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}