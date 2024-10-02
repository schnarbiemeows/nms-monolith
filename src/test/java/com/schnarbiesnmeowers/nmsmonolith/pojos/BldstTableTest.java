package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.BldstTable;







/**
 * class to test the BldstTable class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BldstTableTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		BldstTable classUnderTest = new BldstTable();
		classUnderTest.setBldstTableId(1);
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