package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;



import java.time.LocalDate;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the DailyWeightDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DailyWeightDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyWeightDataPoint classUnderTest = new DailyWeightDataPoint();
		classUnderTest.setDailyWeightId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(LocalDate.now());
		classUnderTest.setWeight(BigDecimal.ONE);
		assertTrue(true);
		DailyWeightDataPoint newitem = new DailyWeightDataPoint(
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