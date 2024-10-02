package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.MuscleGroups;







/**
 * class to test the MuscleGroups class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MuscleGroupsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		MuscleGroups classUnderTest = new MuscleGroups();
		classUnderTest.setMuscleGroupId(1);
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