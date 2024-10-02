package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;


import java.math.BigDecimal;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the DailyDietDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DailyDietDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyDietDTO classUnderTest = new DailyDietDTO();
		classUnderTest.setDailyTotalId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setIngrId(1);
		classUnderTest.setIsRecipe(true);
		classUnderTest.setIsLocal(true);
		classUnderTest.setBldstId(1);
		classUnderTest.setServTypeId(1);
		classUnderTest.setNumSrv(BigDecimal.ONE);
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