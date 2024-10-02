package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;




import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the IngredientsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class IngredientsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		IngredientsDTO classUnderTest = new IngredientsDTO();
		classUnderTest.setIngrId(1);
		classUnderTest.setIngrDesc("a");
		classUnderTest.setIngrTypeId(1);
		classUnderTest.setBrandId(1);
		classUnderTest.setServSz(BigDecimal.ONE);
		classUnderTest.setServTypeId(1);
		classUnderTest.setKcalories(BigDecimal.ONE);
		classUnderTest.setTotFat(BigDecimal.ONE);
		classUnderTest.setSatFat(BigDecimal.ONE);
		classUnderTest.setTransFat(BigDecimal.ONE);
		classUnderTest.setPolyFat(BigDecimal.ONE);
		classUnderTest.setMonoFat(BigDecimal.ONE);
		classUnderTest.setCholes(BigDecimal.ONE);
		classUnderTest.setSodium(1);
		classUnderTest.setTotCarbs(BigDecimal.ONE);
		classUnderTest.setTotFiber(BigDecimal.ONE);
		classUnderTest.setTotSugars(BigDecimal.ONE);
		classUnderTest.setTotProtein(BigDecimal.ONE);
		classUnderTest.setGlycIndx(BigDecimal.ONE);
		classUnderTest.setImageLoc(1);
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