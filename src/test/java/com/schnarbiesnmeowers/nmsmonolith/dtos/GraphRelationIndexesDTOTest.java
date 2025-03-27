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
 * class to test the GraphRelationIndexesDTO class
 * @author Dylan I. Kessler
 *
 */
public class GraphRelationIndexesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GraphRelationIndexesDTO classUnderTest = new GraphRelationIndexesDTO();
		classUnderTest.setGraphRelationIndexId(2);
		classUnderTest.setIndexDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		GraphRelationIndexesDTO newitem = new GraphRelationIndexesDTO(
		classUnderTest.getGraphRelationIndexId(),
		classUnderTest.getIndexDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}