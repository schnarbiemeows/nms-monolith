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
 * class to test the GoalsDTO class
 * @author Dylan I. Kessler
 *
 */
public class GoalsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalsDTO classUnderTest = new GoalsDTO();
		classUnderTest.setGoalId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setGoalName("a");
		classUnderTest.setGcId(2);
		classUnderTest.setComparator("a");
		classUnderTest.setCompFld("a");
		classUnderTest.setNumTimes(2);
		classUnderTest.setTimesMet(2);
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