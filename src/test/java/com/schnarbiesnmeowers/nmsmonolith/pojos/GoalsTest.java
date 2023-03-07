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
 * class to test the Goals class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GoalsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Goals classUnderTest = new Goals();
		classUnderTest.setGoalId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setGoalName("a");
		classUnderTest.setGcId(new Integer(1));
		classUnderTest.setComparator("a");
		classUnderTest.setCompFld("a");
		classUnderTest.setNumTimes(new Integer(1));
		classUnderTest.setTimesMet(new Integer(1));
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