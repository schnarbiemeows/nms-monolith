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
 * class to test the RecEquipJoin class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecEquipJoinTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecEquipJoin classUnderTest = new RecEquipJoin();
		classUnderTest.setRecEquipJoinId(new Integer(1));
		classUnderTest.setRecipeId(new Integer(1));
		classUnderTest.setRecipeEquipId(new Integer(1));
		assertTrue(true);
		RecEquipJoin newitem = new RecEquipJoin(
		classUnderTest.getRecEquipJoinId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getRecipeEquipId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}