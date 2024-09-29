package com.schnarbiesnmeowers.nmsmonolith.pojos;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * class to test the Lifts class
 * @author Dylan I. Kessler
 *
 */
//@RunWith(SpringRunner.class)
public class LiftsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Lifts classUnderTest = new Lifts();
		classUnderTest.setLiftId(1);
		classUnderTest.setLiftDesc("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		Lifts newitem = new Lifts(
		classUnderTest.getLiftId(),
		classUnderTest.getLiftDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv(),
		classUnderTest.getMuscleGroupId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}