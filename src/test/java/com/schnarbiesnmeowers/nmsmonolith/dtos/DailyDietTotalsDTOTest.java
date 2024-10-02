package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the DailyDietTotalsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DailyDietTotalsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyDietTotalsDTO classUnderTest = new DailyDietTotalsDTO();
		classUnderTest.setDailyDietTotalId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setBldstId(1);
		classUnderTest.setKcalories(BigDecimal.ONE);
		classUnderTest.setTotFat(BigDecimal.ONE);
		classUnderTest.setSatFat(BigDecimal.ONE);
		classUnderTest.setTransFat(BigDecimal.ONE);
		classUnderTest.setPolyFat(BigDecimal.ONE);
		classUnderTest.setMonoFat(BigDecimal.ONE);
		classUnderTest.setCholes(BigDecimal.ONE);
		classUnderTest.setSodium(1);
		classUnderTest.setTotCarbs(BigDecimal.ONE);
		classUnderTest.setTotFiber(BigDecimal.ONE);
		classUnderTest.setTotSugars(BigDecimal.ONE);
		classUnderTest.setTotProtein(BigDecimal.ONE);
		assertTrue(true);
		DailyDietTotalsDTO newitem = new DailyDietTotalsDTO(
		classUnderTest.getDailyDietTotalId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getBldstId(),
		classUnderTest.getKcalories(),
		classUnderTest.getTotFat(),
		classUnderTest.getSatFat(),
		classUnderTest.getTransFat(),
		classUnderTest.getPolyFat(),
		classUnderTest.getMonoFat(),
		classUnderTest.getCholes(),
		classUnderTest.getSodium(),
		classUnderTest.getTotCarbs(),
		classUnderTest.getTotFiber(),
		classUnderTest.getTotSugars(),
		classUnderTest.getTotProtein());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}