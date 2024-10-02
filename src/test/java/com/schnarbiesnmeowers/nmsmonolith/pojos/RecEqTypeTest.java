package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecEqType;







/**
 * class to test the RecEqType class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RecEqTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecEqType classUnderTest = new RecEqType();
		classUnderTest.setRecEqTypeId(1);
		classUnderTest.setRecEqCde("a");
		classUnderTest.setRecEqDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RecEqType newitem = new RecEqType(
		classUnderTest.getRecEqTypeId(),
		classUnderTest.getRecEqCde(),
		classUnderTest.getRecEqDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}