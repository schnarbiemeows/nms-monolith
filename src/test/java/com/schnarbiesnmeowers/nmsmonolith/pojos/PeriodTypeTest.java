package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.PeriodType;







/**
 * class to test the PeriodType class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PeriodTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PeriodType classUnderTest = new PeriodType();
		classUnderTest.setPeriodTypeId(1);
		classUnderTest.setPeriodTypeCde("a");
		classUnderTest.setPeriodTypeDesc("a");
		assertTrue(true);
		PeriodType newitem = new PeriodType(
		classUnderTest.getPeriodTypeId(),
		classUnderTest.getPeriodTypeCde(),
		classUnderTest.getPeriodTypeDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}