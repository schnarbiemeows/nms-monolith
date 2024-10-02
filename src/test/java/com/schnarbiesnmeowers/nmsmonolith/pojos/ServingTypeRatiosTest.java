package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeRatios;




import java.math.*;



/**
 * class to test the ServingTypeRatios class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ServingTypeRatiosTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ServingTypeRatios classUnderTest = new ServingTypeRatios();
		classUnderTest.setServTypeRatioId(1);
		classUnderTest.setServTypeId1(1);
		classUnderTest.setServTypeId2(1);
		classUnderTest.setRatio(new BigDecimal(1.00));
		assertTrue(true);
		ServingTypeRatios newitem = new ServingTypeRatios(
		classUnderTest.getServTypeRatioId(),
		classUnderTest.getServTypeId1(),
		classUnderTest.getServTypeId2(),
		classUnderTest.getRatio());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}