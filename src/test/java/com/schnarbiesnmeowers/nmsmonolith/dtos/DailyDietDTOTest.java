package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the DailyDietDTO class
 * @author Dylan I. Kessler
 *
 */
public class DailyDietDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyDietDTO classUnderTest = new DailyDietDTO();
		classUnderTest.setDailyTotalId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setIngrId(2);
		classUnderTest.setIsRecipe(true);
		classUnderTest.setIsLocal(true);
		classUnderTest.setBldstId(2);
		classUnderTest.setNumSrv(new BigDecimal(1.00));
		classUnderTest.setServTypeId(2);
		classUnderTest.setTimeEaten(Randomizer.randomString(10));
		assertTrue(true);
		DailyDietDTO newitem = new DailyDietDTO(
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