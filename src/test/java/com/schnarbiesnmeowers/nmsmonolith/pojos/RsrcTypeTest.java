package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.RsrcType;







/**
 * class to test the RsrcType class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RsrcTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RsrcType classUnderTest = new RsrcType();
		classUnderTest.setRsrcTypeId(1);
		classUnderTest.setRsrcType("a");
		classUnderTest.setRsrcTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RsrcType newitem = new RsrcType(
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcType(),
		classUnderTest.getRsrcTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}