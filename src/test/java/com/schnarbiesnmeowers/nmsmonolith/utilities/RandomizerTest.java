package com.schnarbiesnmeowers.nmsmonolith.utilities;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.math.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * class to test the Randomizer class
 * @author Dylan I. Kessler
 *
 */
public class RandomizerTest {

	@Test
	public void testMethods() {
	    Randomizer rand = new Randomizer();
		assertNotNull(Randomizer.randomString(10));
		assertNotNull(Randomizer.randomInt(10)) ;
		assertNotNull(Randomizer.randomLong(10)) ;
		assertNotNull(Randomizer.randomFloat(10F)) ;
		assertNotNull(Randomizer.randomDouble(10));
		assertNotNull(Randomizer.randomBigDecimal("10"));
		assertNotNull(Randomizer.randomBigInteger("10"));
		assertNotNull(Randomizer.randomDate()) ;
		assertNotNull(Randomizer.randomTimestamp(1000)) ;
		assertNotNull(Randomizer.randomTime(1000)) ;
		assertNotNull(Randomizer.randomBytes(10)) ;
	}
}
