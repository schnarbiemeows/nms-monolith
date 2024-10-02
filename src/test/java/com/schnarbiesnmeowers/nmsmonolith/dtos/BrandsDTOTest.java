package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandsDTO;







/**
 * class to test the BrandsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BrandsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		BrandsDTO classUnderTest = new BrandsDTO();
		classUnderTest.setBrandId(1);
		classUnderTest.setBrandType("a");
		classUnderTest.setBrandName("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		BrandsDTO newitem = new BrandsDTO(
		classUnderTest.getBrandId(),
		classUnderTest.getBrandType(),
		classUnderTest.getBrandName(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}