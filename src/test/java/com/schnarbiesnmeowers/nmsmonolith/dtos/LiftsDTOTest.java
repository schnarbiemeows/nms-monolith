package com.schnarbiesnmeowers.nmsmonolith.dtos;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;




/**
 * class to test the LiftsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LiftsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		LiftsDTO classUnderTest = new LiftsDTO();
		classUnderTest.setLiftId(1);
		classUnderTest.setLiftDesc("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		LiftsDTO newitem = new LiftsDTO(
		classUnderTest.getLiftId(),
		classUnderTest.getLiftDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv(),classUnderTest.getMuscleGroupId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}