package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the GoalsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GoalsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalsDTO classUnderTest = new GoalsDTO();
		classUnderTest.setGoalId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setGoalName("a");
		classUnderTest.setGcId(1);
		classUnderTest.setComparator("a");
		classUnderTest.setCompFld("a");
		classUnderTest.setNumTimes(1);
		classUnderTest.setTimesMet(1);
		classUnderTest.setConseq("a");
		classUnderTest.setRenew("a");
		classUnderTest.setAchieved("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		GoalsDTO newitem = new GoalsDTO(
		classUnderTest.getGoalId(),
		classUnderTest.getUserId(),
		classUnderTest.getGoalName(),
		classUnderTest.getGcId(),
		classUnderTest.getComparator(),
		classUnderTest.getCompFld(),
		classUnderTest.getNumTimes(),
		classUnderTest.getTimesMet(),
		classUnderTest.getConseq(),
		classUnderTest.getRenew(),
		classUnderTest.getAchieved(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}