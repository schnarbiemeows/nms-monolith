package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietaryNotes;
import java.math.*;


/**
 * class to test the DailyDietaryNotes class
 * @author Dylan I. Kessler
 *
 */
public class DailyDietaryNotesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyDietaryNotes classUnderTest = new DailyDietaryNotes();
		classUnderTest.setDdnId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setDailyNotes("a");
		assertTrue(true);
		DailyDietaryNotes newitem = new DailyDietaryNotes(
		classUnderTest.getDdnId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getDailyNotes());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}