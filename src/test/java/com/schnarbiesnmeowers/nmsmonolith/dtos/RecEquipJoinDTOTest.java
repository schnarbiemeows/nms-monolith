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
 * class to test the RecEquipJoinDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecEquipJoinDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecEquipJoinDTO classUnderTest = new RecEquipJoinDTO();
		classUnderTest.setRecEquipJoinId(new Integer(1));
		classUnderTest.setRecipeId(new Integer(1));
		classUnderTest.setRecipeEquipId(new Integer(1));
		assertTrue(true);
		RecEquipJoinDTO newitem = new RecEquipJoinDTO(
		classUnderTest.getRecEquipJoinId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getRecipeEquipId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}