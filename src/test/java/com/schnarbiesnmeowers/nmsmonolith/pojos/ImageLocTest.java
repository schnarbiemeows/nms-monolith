package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the ImageLoc class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ImageLocTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ImageLoc classUnderTest = new ImageLoc();
		classUnderTest.setImageLocId(new Integer(1));
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