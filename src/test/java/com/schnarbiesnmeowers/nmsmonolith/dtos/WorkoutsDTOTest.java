package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutsDTO;
import java.math.BigDecimal;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the WorkoutsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WorkoutsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		WorkoutsDTO classUnderTest = new WorkoutsDTO();
		classUnderTest.setWorkoutId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(LocalDate.now());
		classUnderTest.setExerciseTypeId(1);
		classUnderTest.setDuration(1);
		classUnderTest.setRating(BigDecimal.ONE);
		classUnderTest.setActv("a");
		classUnderTest.setNotes("notes");
		assertTrue(true);
		WorkoutsDTO newitem = new WorkoutsDTO(
		classUnderTest.getWorkoutId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getExerciseTypeId(),
		classUnderTest.getDuration(),
		classUnderTest.getRating(),
		classUnderTest.getActv(),
		classUnderTest.getNotes());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}