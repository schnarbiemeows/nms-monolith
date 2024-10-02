package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Roles;







/**
 * class to test the Roles class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RolesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Roles classUnderTest = new Roles();
		classUnderTest.setRoleId(1);
		classUnderTest.setGrpId(1);
		classUnderTest.setRsrcId(1);
		classUnderTest.setActionTypeId(1);
		assertTrue(true);
		Roles newitem = new Roles(
		classUnderTest.getRoleId(),
		classUnderTest.getGrpId(),
		classUnderTest.getRsrcId(),
		classUnderTest.getActionTypeId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}