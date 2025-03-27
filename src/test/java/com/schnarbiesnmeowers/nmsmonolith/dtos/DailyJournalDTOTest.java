package com.schnarbiesnmeowers.nmsmonolith.dtos;

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
 * class to test the DailyJournalDTO class
 * @author Dylan I. Kessler
 *
 */
public class DailyJournalDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyJournalDTO classUnderTest = new DailyJournalDTO();
		classUnderTest.setDailyJournalId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setNote("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		DailyJournalDTO newitem = new DailyJournalDTO(
		classUnderTest.getDailyJournalId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getNote(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}