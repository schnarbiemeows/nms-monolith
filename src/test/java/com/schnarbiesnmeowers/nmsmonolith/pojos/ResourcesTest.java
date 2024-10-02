package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Resources;







/**
 * class to test the Resources class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ResourcesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Resources classUnderTest = new Resources();
		classUnderTest.setRsrcId(1);
		classUnderTest.setRsrcTypeId(1);
		classUnderTest.setRsrcDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		Resources newitem = new Resources(
		classUnderTest.getRsrcId(),
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}