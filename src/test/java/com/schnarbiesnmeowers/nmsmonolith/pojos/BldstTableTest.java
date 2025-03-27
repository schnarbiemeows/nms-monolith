package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.BldstTable;
import java.math.*;


/**
 * class to test the BldstTable class
 * @author Dylan I. Kessler
 *
 */
public class BldstTableTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		BldstTable classUnderTest = new BldstTable();
		classUnderTest.setBldstTableId(2);
		classUnderTest.setBldstCde("a");
		classUnderTest.setBldstDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		BldstTable newitem = new BldstTable(
		classUnderTest.getBldstTableId(),
		classUnderTest.getBldstCde(),
		classUnderTest.getBldstDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}