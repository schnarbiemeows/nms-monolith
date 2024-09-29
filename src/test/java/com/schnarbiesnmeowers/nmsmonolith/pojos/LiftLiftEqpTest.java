package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the LiftLiftEqp class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class LiftLiftEqpTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		LiftLiftEqp classUnderTest = new LiftLiftEqp();
		classUnderTest.setLiftLiftEqpId(new Integer(1));
		classUnderTest.setLiftId(new Integer(1));
		classUnderTest.setLiftEquipId(new Integer(1));
		assertTrue(true);
		LiftLiftEqp newitem = new LiftLiftEqp(
		classUnderTest.getLiftLiftEqpId(),
		classUnderTest.getLiftId(),
		classUnderTest.getLiftEquipId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}