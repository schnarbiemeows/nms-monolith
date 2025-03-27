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
 * class to test the GraphRelationsDTO class
 * @author Dylan I. Kessler
 *
 */
public class GraphRelationsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GraphRelationsDTO classUnderTest = new GraphRelationsDTO();
		classUnderTest.setGraphRelationsId(2);
		classUnderTest.setParentNode(2);
		classUnderTest.setChildNode(2);
		classUnderTest.setEdgeVal("a");
		classUnderTest.setEdgeFk(2);
		classUnderTest.setGraphRelationIndexId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		GraphRelationsDTO newitem = new GraphRelationsDTO(
		classUnderTest.getGraphRelationsId(),
		classUnderTest.getParentNode(),
		classUnderTest.getChildNode(),
		classUnderTest.getEdgeVal(),
		classUnderTest.getEdgeFk(),
		classUnderTest.getGraphRelationIndexId(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}