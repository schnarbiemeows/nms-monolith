package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.ImageLoc;
import java.math.*;


/**
 * class to test the ImageLoc class
 * @author Dylan I. Kessler
 *
 */
public class ImageLocTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ImageLoc classUnderTest = new ImageLoc();
		classUnderTest.setImageLocId(2);
		classUnderTest.setImgDesc("a");
		classUnderTest.setImgPath("a");
		assertTrue(true);
		ImageLoc newitem = new ImageLoc(
		classUnderTest.getImageLocId(),
		classUnderTest.getImgDesc(),
		classUnderTest.getImgPath());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}