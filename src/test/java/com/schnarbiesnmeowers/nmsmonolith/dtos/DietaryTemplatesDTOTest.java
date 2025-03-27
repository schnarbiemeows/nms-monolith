package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DietaryTemplatesDTO;
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
 * class to test the DietaryTemplatesDTO class
 * @author Dylan I. Kessler
 *
 */
public class DietaryTemplatesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DietaryTemplatesDTO classUnderTest = new DietaryTemplatesDTO();
		classUnderTest.setDietaryTemplateId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setTemplateName("a");
		assertTrue(true);
		DietaryTemplatesDTO newitem = new DietaryTemplatesDTO(
		classUnderTest.getDietaryTemplateId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getTemplateName());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}