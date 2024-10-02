package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietaryNotes;


import java.util.*;





/**
 * class to test the DailyDietaryNotes class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DailyDietaryNotesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyDietaryNotes classUnderTest = new DailyDietaryNotes();
		classUnderTest.setDdnId(1);
		classUnderTest.setUserId(1);
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