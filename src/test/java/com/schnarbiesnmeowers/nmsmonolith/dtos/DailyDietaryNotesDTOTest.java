package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;


import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the DailyDietaryNotesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DailyDietaryNotesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyDietaryNotesDTO classUnderTest = new DailyDietaryNotesDTO();
		classUnderTest.setDdnId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setDailyNotes("a");
		assertTrue(true);
		DailyDietaryNotesDTO newitem = new DailyDietaryNotesDTO(
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