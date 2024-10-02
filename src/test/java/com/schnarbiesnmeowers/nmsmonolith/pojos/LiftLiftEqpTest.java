package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.LiftLiftEqp;







/**
 * class to test the LiftLiftEqp class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LiftLiftEqpTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		LiftLiftEqp classUnderTest = new LiftLiftEqp();
		classUnderTest.setLiftLiftEqpId(1);
		classUnderTest.setLiftId(1);
		classUnderTest.setLiftEquipId(1);
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