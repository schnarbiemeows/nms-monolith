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
 * class to test the MuscleGroups class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class MuscleGroupsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		MuscleGroups classUnderTest = new MuscleGroups();
		classUnderTest.setMuscleGroupId(new Integer(1));
		classUnderTest.setMuscleGrpName("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		MuscleGroups newitem = new MuscleGroups(
		classUnderTest.getMuscleGroupId(),
		classUnderTest.getMuscleGrpName(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}