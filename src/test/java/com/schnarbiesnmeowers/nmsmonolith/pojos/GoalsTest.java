package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Goals;







/**
 * class to test the Goals class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GoalsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Goals classUnderTest = new Goals();
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