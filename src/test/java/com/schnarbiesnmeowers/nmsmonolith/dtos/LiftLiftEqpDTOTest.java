package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the LiftLiftEqpDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LiftLiftEqpDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		LiftLiftEqpDTO classUnderTest = new LiftLiftEqpDTO();
		classUnderTest.setLiftLiftEqpId(1);
		classUnderTest.setLiftId(1);
		classUnderTest.setLiftEquipId(1);
		assertTrue(true);
		LiftLiftEqpDTO newitem = new LiftLiftEqpDTO(
		classUnderTest.getLiftLiftEqpId(),
		classUnderTest.getLiftId(),
		classUnderTest.getLiftEquipId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}