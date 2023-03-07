package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;

import static org.junit.Assert.*;

import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the IngredientsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class IngredientsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		IngredientsDTO classUnderTest = new IngredientsDTO();
		classUnderTest.setIngrId(new Integer(1));
		classUnderTest.setIngrDesc("a");
		classUnderTest.setIngrTypeId(new Integer(1));
		classUnderTest.setBrandId(new Integer(1));
		classUnderTest.setServSz(new BigDecimal(1.00));
		classUnderTest.setServTypeId(new Integer(1));
		classUnderTest.setKcalories(new BigDecimal(1.00));
		classUnderTest.setTotFat(new BigDecimal(1.00));
		classUnderTest.setSatFat(new BigDecimal(1.00));
		classUnderTest.setTransFat(new BigDecimal(1.00));
		classUnderTest.setPolyFat(new BigDecimal(1.00));
		classUnderTest.setMonoFat(new BigDecimal(1.00));
		classUnderTest.setCholes(new BigDecimal(1.00));
		classUnderTest.setSodium(new Integer(1));
		classUnderTest.setTotCarbs(new BigDecimal(1.00));
		classUnderTest.setTotFiber(new BigDecimal(1.00));
		classUnderTest.setTotSugars(new BigDecimal(1.00));
		classUnderTest.setTotProtein(new BigDecimal(1.00));
		classUnderTest.setGlycIndx(new BigDecimal(1.00));
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		IngredientsDTO newitem = new IngredientsDTO(
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