package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.LiftSteps;







/**
 * class to test the LiftSteps class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LiftStepsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		LiftSteps classUnderTest = new LiftSteps();
		classUnderTest.setLiftStepId(1);
		classUnderTest.setLiftId(1);
		classUnderTest.setStepNum(1);
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(1);
		assertTrue(true);
		LiftSteps newitem = new LiftSteps(
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