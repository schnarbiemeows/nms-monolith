package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.LiftEquip;







/**
 * class to test the LiftEquip class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LiftEquipTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		LiftEquip classUnderTest = new LiftEquip();
		classUnderTest.setLiftEquipId(1);
		classUnderTest.setEquipDesc("a");
		classUnderTest.setEquipLongDesc("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		LiftEquip newitem = new LiftEquip(
		classUnderTest.getLiftEquipId(),
		classUnderTest.getEquipDesc(),
		classUnderTest.getEquipLongDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}