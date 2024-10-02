package com.schnarbiesnmeowers.nmsmonolith.pojos;



import java.time.LocalDate;

import com.schnarbiesnmeowers.nmsmonolith.entities.DailyWeight;

import java.math.*;



/**
 * class to test the DailyWeight class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DailyWeightTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyWeight classUnderTest = new DailyWeight();
		classUnderTest.setDailyWeightId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(LocalDate.now());
		classUnderTest.setWeight(new BigDecimal(1.00));
		assertTrue(true);
		DailyWeight newitem = new DailyWeight(
		classUnderTest.getDailyWeightId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getWeight());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}