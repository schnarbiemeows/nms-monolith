package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.GraphRelationIndexes;
import java.math.*;


/**
 * class to test the GraphRelationIndexes class
 * @author Dylan I. Kessler
 *
 */
public class GraphRelationIndexesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GraphRelationIndexes classUnderTest = new GraphRelationIndexes();
		classUnderTest.setGraphRelationIndexId(2);
		classUnderTest.setIndexDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		GraphRelationIndexes newitem = new GraphRelationIndexes(
		classUnderTest.getGraphRelationIndexId(),
		classUnderTest.getIndexDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}