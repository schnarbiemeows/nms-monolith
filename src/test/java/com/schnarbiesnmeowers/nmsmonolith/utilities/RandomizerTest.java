package com.schnarbiesnmeowers.nmsmonolith.utilities;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;




/**
 * class to test the Randomizer class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RandomizerTest {

	//@Test
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
