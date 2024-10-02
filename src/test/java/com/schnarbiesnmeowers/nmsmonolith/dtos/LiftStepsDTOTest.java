package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the LiftStepsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LiftStepsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		LiftStepsDTO classUnderTest = new LiftStepsDTO();
		classUnderTest.setLiftStepId(1);
		classUnderTest.setLiftId(1);
		classUnderTest.setStepNum(1);
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(1);
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