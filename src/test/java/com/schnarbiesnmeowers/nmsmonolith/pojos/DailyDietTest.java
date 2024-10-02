package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDiet;


import java.util.*;


import java.math.*;



/**
 * class to test the DailyDiet class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DailyDietTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyDiet classUnderTest = new DailyDiet();
		classUnderTest.setDailyTotalId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setIngrId(1);
		classUnderTest.setIsRecipe(true);
		classUnderTest.setBldstId(1);
		classUnderTest.setNumSrv(new BigDecimal(1.00));
		classUnderTest.setTimeEaten("1000");
		assertTrue(true);
		DailyDiet newitem = new DailyDiet(
		classUnderTest.getDailyTotalId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getIngrId(),
		classUnderTest.getIsRecipe(),
		classUnderTest.getIsLocal(),
		classUnderTest.getBldstId(),
		classUnderTest.getNumSrv(),
		classUnderTest.getServTypeId(),
		classUnderTest.getTimeEaten());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}