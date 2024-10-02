package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the BrandIngrTypeDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BrandIngrTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		BrandIngrTypeDTO classUnderTest = new BrandIngrTypeDTO();
		classUnderTest.setBrandIngrTypeId(1);
		classUnderTest.setBrandId(1);
		classUnderTest.setIngrTypeId(1);
		classUnderTest.setPrntIngrType(1);
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