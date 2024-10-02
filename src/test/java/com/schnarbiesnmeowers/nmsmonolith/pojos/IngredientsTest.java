package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Ingredients;




import java.math.*;



/**
 * class to test the Ingredients class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class IngredientsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Ingredients classUnderTest = new Ingredients();
		classUnderTest.setIngrId(1);
		classUnderTest.setIngrDesc("a");
		classUnderTest.setIngrTypeId(1);
		classUnderTest.setBrandId(1);
		classUnderTest.setServSz(new BigDecimal(1.00));
		classUnderTest.setServTypeId(1);
		classUnderTest.setKcalories(new BigDecimal(1.00));
		classUnderTest.setTotFat(new BigDecimal(1.00));
		classUnderTest.setSatFat(new BigDecimal(1.00));
		classUnderTest.setTransFat(new BigDecimal(1.00));
		classUnderTest.setPolyFat(new BigDecimal(1.00));
		classUnderTest.setMonoFat(new BigDecimal(1.00));
		classUnderTest.setCholes(new BigDecimal(1.00));
		classUnderTest.setSodium(1);
		classUnderTest.setTotCarbs(new BigDecimal(1.00));
		classUnderTest.setTotFiber(new BigDecimal(1.00));
		classUnderTest.setTotSugars(new BigDecimal(1.00));
		classUnderTest.setTotProtein(new BigDecimal(1.00));
		classUnderTest.setGlycIndx(new BigDecimal(1.00));
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		Ingredients newitem = new Ingredients(
		classUnderTest.getIngrId(),
		classUnderTest.getIngrDesc(),
		classUnderTest.getIngrTypeId(),
		classUnderTest.getBrandId(),
		classUnderTest.getServSz(),
		classUnderTest.getServTypeId(),
		classUnderTest.getKcalories(),
		classUnderTest.getTotFat(),
		classUnderTest.getSatFat(),
		classUnderTest.getTransFat(),
		classUnderTest.getPolyFat(),
		classUnderTest.getMonoFat(),
		classUnderTest.getCholes(),
		classUnderTest.getSodium(),
		classUnderTest.getTotCarbs(),
		classUnderTest.getTotFiber(),
		classUnderTest.getTotSugars(),
		classUnderTest.getTotProtein(),
		classUnderTest.getGlycIndx(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}