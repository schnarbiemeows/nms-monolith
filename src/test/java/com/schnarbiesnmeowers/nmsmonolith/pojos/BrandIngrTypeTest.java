package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.BrandIngrType;







/**
 * class to test the BrandIngrType class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BrandIngrTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		BrandIngrType classUnderTest = new BrandIngrType();
		classUnderTest.setBrandIngrTypeId(1);
		classUnderTest.setBrandId(1);
		classUnderTest.setIngrTypeId(1);
		classUnderTest.setPrntIngrType(1);
		assertTrue(true);
		BrandIngrType newitem = new BrandIngrType(
		classUnderTest.getBrandIngrTypeId(),
		classUnderTest.getBrandId(),
		classUnderTest.getIngrTypeId(),
		classUnderTest.getPrntIngrType());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}