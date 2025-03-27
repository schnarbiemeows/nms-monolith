package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.LimitterSettings;
import java.math.*;


/**
 * class to test the LimitterSettings class
 * @author Dylan I. Kessler
 *
 */
public class LimitterSettingsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LimitterSettings classUnderTest = new LimitterSettings();
		classUnderTest.setSettingId(2);
		classUnderTest.setUrl("a");
		classUnderTest.setDomain("a");
		classUnderTest.setPermissions("a");
		classUnderTest.setTotnumreqpersec(2);
		classUnderTest.setWndwforratelmtinms(2);
		classUnderTest.setTotalmaxbucketsize(2);
		classUnderTest.setIptotnumreqpersec(2);
		classUnderTest.setIpwndwrtlmt(2);
		classUnderTest.setIpmaxwndw(2);
		classUnderTest.setEnvironment("a");
		assertTrue(true);
		LimitterSettings newitem = new LimitterSettings(
		classUnderTest.getSettingId(),
		classUnderTest.getUrl(),
		classUnderTest.getDomain(),
		classUnderTest.getPermissions(),
		classUnderTest.getTotnumreqpersec(),
		classUnderTest.getWndwforratelmtinms(),
		classUnderTest.getTotalmaxbucketsize(),
		classUnderTest.getIptotnumreqpersec(),
		classUnderTest.getIpwndwrtlmt(),
		classUnderTest.getIpmaxwndw(),
		classUnderTest.getEnvironment());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}