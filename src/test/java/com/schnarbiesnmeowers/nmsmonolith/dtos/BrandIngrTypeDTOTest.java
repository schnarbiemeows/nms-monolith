package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the BrandIngrTypeDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class BrandIngrTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		BrandIngrTypeDTO classUnderTest = new BrandIngrTypeDTO();
		classUnderTest.setBrandIngrTypeId(new Integer(1));
		classUnderTest.setBrandId(new Integer(1));
		classUnderTest.setIngrTypeId(new Integer(1));
		classUnderTest.setPrntIngrType(new Integer(1));
		assertTrue(true);
		BrandIngrTypeDTO newitem = new BrandIngrTypeDTO(
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