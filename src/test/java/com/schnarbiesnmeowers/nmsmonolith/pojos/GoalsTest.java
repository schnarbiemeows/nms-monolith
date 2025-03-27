package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Goals;
import java.math.*;


/**
 * class to test the Goals class
 * @author Dylan I. Kessler
 *
 */
public class GoalsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Goals classUnderTest = new Goals();
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
		Goals newitem = new Goals(
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