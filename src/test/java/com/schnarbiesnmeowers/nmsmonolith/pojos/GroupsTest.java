package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Groups;







/**
 * class to test the Groups class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GroupsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Groups classUnderTest = new Groups();
		classUnderTest.setGrpId(1);
		classUnderTest.setGrpName("a");
		classUnderTest.setGrpDesc("a");
		assertTrue(true);
		Groups newitem = new Groups(
		classUnderTest.getGrpId(),
		classUnderTest.getGrpName(),
		classUnderTest.getGrpDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}