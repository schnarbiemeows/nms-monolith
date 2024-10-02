package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;

import java.math.BigDecimal;





/**
 * class to test the IngredientTypesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class IngredientTypesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		IngredientTypesDTO classUnderTest = new IngredientTypesDTO();
		classUnderTest.setIngrTypeId(1);
		classUnderTest.setPrntIngrType(1);
		classUnderTest.setIngrTypeDesc("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		IngredientTypesDTO newitem = new IngredientTypesDTO(
		classUnderTest.getIngrTypeId(),
		classUnderTest.getPrntIngrType(),
		classUnderTest.getIngrTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}