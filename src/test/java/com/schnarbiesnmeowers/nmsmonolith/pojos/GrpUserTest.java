package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GrpUser;







/**
 * class to test the GrpUser class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GrpUserTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GrpUser classUnderTest = new GrpUser();
		classUnderTest.setGrpUserId(1);
		classUnderTest.setGrpId(1);
		classUnderTest.setUserId(1);
		assertTrue(true);
		GrpUser newitem = new GrpUser(
		classUnderTest.getGrpUserId(),
		classUnderTest.getGrpId(),
		classUnderTest.getUserId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}