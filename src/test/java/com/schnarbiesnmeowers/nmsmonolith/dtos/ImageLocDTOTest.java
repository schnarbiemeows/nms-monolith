package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the ImageLocDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ImageLocDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ImageLocDTO classUnderTest = new ImageLocDTO();
		classUnderTest.setImageLocId(1);
		classUnderTest.setImgDesc("a");
		classUnderTest.setImgPath("a");
		assertTrue(true);
		ImageLocDTO newitem = new ImageLocDTO(
		classUnderTest.getImageLocId(),
		classUnderTest.getImgDesc(),
		classUnderTest.getImgPath());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}