package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.repositories.IngredientsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.IngredientsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the IngredientsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class IngredientsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private IngredientsController ingredientsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private IngredientsService ingredientsService;

    @Mock
    private IngredientsRepository ingredientsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientsController).build();
    }

	/**
	 * test creating a new Ingredients
	 * @throws 
	 */
	@Test
	public void testA_CreateIngredients() throws Exception
	{
	    IngredientsDTO ingredients = generateRandomIngredients();
        when(ingredientsService.createIngredients(any(IngredientsDTO.class))).thenReturn(ingredients);

        mockMvc.perform(post("/ingredients/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ingredients)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Ingredients
	 * @throws 
	 */
	@Test
	public void testB_GetAllIngredients() throws Exception
	{
		List<IngredientsDTO> ingredientss = Arrays.asList(generateRandomIngredients(), generateRandomIngredients());
        when(ingredientsService.getAllIngredients()).thenReturn(ingredientss);

        mockMvc.perform(get("/ingredients/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Ingredients by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetIngredients() throws Exception
	{
		IngredientsDTO ingredients = generateRandomIngredients();
        when(ingredientsService.findIngredientsById(anyInt())).thenReturn(ingredients);

        mockMvc.perform(get("/ingredients/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Ingredients
	 * @throws 
	 */
	@Test
	public void testD_UpdateIngredients() throws Exception
	{
	    IngredientsDTO ingredients = generateRandomIngredients();
        when(ingredientsService.updateIngredients(any(IngredientsDTO.class))).thenReturn(ingredients);

        mockMvc.perform(post("/ingredients/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ingredients)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Ingredients
	 * @throws 
	 */
	@Test
	public void testE_DeleteIngredients() throws Exception
	{
		when(ingredientsService.deleteIngredients(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/ingredients/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Ingredients by field IngrTypeId
 * @throws
 */
@Test
public void testC_findByIngrTypeId() throws Exception
{
    List<IngredientsDTO> ingredients = Arrays.asList(generateRandomIngredients());
    when(ingredientsService.findIngredientsByIngrTypeId(anyInt())).thenReturn(ingredients);

    mockMvc.perform(get("/ingredients/findByIngrTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Ingredients by field BrandId
 * @throws
 */
@Test
public void testC_findByBrandId() throws Exception
{
    List<IngredientsDTO> ingredients = Arrays.asList(generateRandomIngredients());
    when(ingredientsService.findIngredientsByBrandId(anyInt())).thenReturn(ingredients);

    mockMvc.perform(get("/ingredients/findByBrandId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Ingredients by field ServTypeId
 * @throws
 */
@Test
public void testC_findByServTypeId() throws Exception
{
    List<IngredientsDTO> ingredients = Arrays.asList(generateRandomIngredients());
    when(ingredientsService.findIngredientsByServTypeId(anyInt())).thenReturn(ingredients);

    mockMvc.perform(get("/ingredients/findByServTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Ingredients by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<IngredientsDTO> ingredients = Arrays.asList(generateRandomIngredients());
    when(ingredientsService.findIngredientsByImageLoc(anyInt())).thenReturn(ingredients);

    mockMvc.perform(get("/ingredients/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static IngredientsDTO generateRandomIngredients() {
		IngredientsDTO record = new IngredientsDTO();
		record.setIngrDesc(Randomizer.randomString(20));
		record.setIngrTypeId(Randomizer.randomInt(1000));
		record.setBrandId(Randomizer.randomInt(1000));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setKcalories(Randomizer.randomBigDecimal("1000"));
		record.setTotFat(Randomizer.randomBigDecimal("1000"));
		record.setSatFat(Randomizer.randomBigDecimal("1000"));
		record.setTransFat(Randomizer.randomBigDecimal("1000"));
		record.setPolyFat(Randomizer.randomBigDecimal("1000"));
		record.setMonoFat(Randomizer.randomBigDecimal("1000"));
		record.setCholes(Randomizer.randomBigDecimal("1000"));
		record.setSodium(Randomizer.randomInt(1000));
		record.setTotCarbs(Randomizer.randomBigDecimal("1000"));
		record.setTotFiber(Randomizer.randomBigDecimal("1000"));
		record.setTotSugars(Randomizer.randomBigDecimal("1000"));
		record.setTotProtein(Randomizer.randomBigDecimal("1000"));
		record.setGlycIndx(Randomizer.randomBigDecimal("1000"));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}