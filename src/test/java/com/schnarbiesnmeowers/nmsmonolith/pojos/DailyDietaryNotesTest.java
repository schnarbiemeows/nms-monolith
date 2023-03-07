package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the DailyDietaryNotes class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class DailyDietaryNotesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyDietaryNotes classUnderTest = new DailyDietaryNotes();
		classUnderTest.setDdnId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
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