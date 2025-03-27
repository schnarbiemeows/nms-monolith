package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.GraphRelations;
import java.math.*;


/**
 * class to test the GraphRelations class
 * @author Dylan I. Kessler
 *
 */
public class GraphRelationsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GraphRelations classUnderTest = new GraphRelations();
		classUnderTest.setGraphRelationsId(2);
		classUnderTest.setParentNode(2);
		classUnderTest.setChildNode(2);
		classUnderTest.setEdgeVal("a");
		classUnderTest.setEdgeFk(2);
		classUnderTest.setGraphRelationIndexId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		GraphRelations newitem = new GraphRelations(
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