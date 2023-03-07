package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the DailyDietDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class DailyDietDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyDietDTO classUnderTest = new DailyDietDTO();
		classUnderTest.setDailyTotalId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setIngrId(new Integer(1));
		classUnderTest.setIsRecipe(true);
		classUnderTest.setIsLocal(true);
		classUnderTest.setBldstId(new Integer(1));
		classUnderTest.setServTypeId(new Integer(1));
		classUnderTest.setNumSrv(new BigDecimal(1.00));
		classUnderTest.setTimeEaten("1000");
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