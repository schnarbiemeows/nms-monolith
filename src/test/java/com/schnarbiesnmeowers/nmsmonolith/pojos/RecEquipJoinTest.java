package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecEquipJoin;







/**
 * class to test the RecEquipJoin class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RecEquipJoinTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecEquipJoin classUnderTest = new RecEquipJoin();
		classUnderTest.setRecEquipJoinId(1);
		classUnderTest.setRecipeId(1);
		classUnderTest.setRecipeEquipId(1);
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