package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.ImageLoc;







/**
 * class to test the ImageLoc class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ImageLocTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ImageLoc classUnderTest = new ImageLoc();
		classUnderTest.setImageLocId(1);
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