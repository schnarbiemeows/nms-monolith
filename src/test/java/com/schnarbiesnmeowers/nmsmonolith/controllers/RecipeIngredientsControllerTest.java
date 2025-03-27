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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeIngredientsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeIngredientsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipeIngredientsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RecipeIngredientsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RecipeIngredientsController recipeingredientsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RecipeIngredientsService recipeingredientsService;

    @Mock
    private RecipeIngredientsRepository recipeingredientsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(recipeingredientsController).build();
    }

	/**
	 * test creating a new RecipeIngredients
	 * @throws 
	 */
	@Test
	public void testA_CreateRecipeIngredients() throws Exception
	{
	    RecipeIngredientsDTO recipeingredients = generateRandomRecipeIngredients();
        when(recipeingredientsService.createRecipeIngredients(any(RecipeIngredientsDTO.class))).thenReturn(recipeingredients);

        mockMvc.perform(post("/recipeingredients/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipeingredients)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RecipeIngredients
	 * @throws 
	 */
	@Test
	public void testB_GetAllRecipeIngredients() throws Exception
	{
		List<RecipeIngredientsDTO> recipeingredientss = Arrays.asList(generateRandomRecipeIngredients(), generateRandomRecipeIngredients());
        when(recipeingredientsService.getAllRecipeIngredients()).thenReturn(recipeingredientss);

        mockMvc.perform(get("/recipeingredients/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RecipeIngredients by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRecipeIngredients() throws Exception
	{
		RecipeIngredientsDTO recipeingredients = generateRandomRecipeIngredients();
        when(recipeingredientsService.findRecipeIngredientsById(anyInt())).thenReturn(recipeingredients);

        mockMvc.perform(get("/recipeingredients/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RecipeIngredients
	 * @throws 
	 */
	@Test
	public void testD_UpdateRecipeIngredients() throws Exception
	{
	    RecipeIngredientsDTO recipeingredients = generateRandomRecipeIngredients();
        when(recipeingredientsService.updateRecipeIngredients(any(RecipeIngredientsDTO.class))).thenReturn(recipeingredients);

        mockMvc.perform(post("/recipeingredients/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipeingredients)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RecipeIngredients
	 * @throws 
	 */
	@Test
	public void testE_DeleteRecipeIngredients() throws Exception
	{
		when(recipeingredientsService.deleteRecipeIngredients(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/recipeingredients/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single RecipeIngredients by field RecipeId
 * @throws
 */
@Test
public void testC_findByRecipeId() throws Exception
{
    List<RecipeIngredientsDTO> recipeingredients = Arrays.asList(generateRandomRecipeIngredients());
    when(recipeingredientsService.findRecipeIngredientsByRecipeId(anyInt())).thenReturn(recipeingredients);

    mockMvc.perform(get("/recipeingredients/findByRecipeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single RecipeIngredients by field ServTypeId
 * @throws
 */

	public static RecipeIngredientsDTO generateRandomRecipeIngredients() {
		RecipeIngredientsDTO record = new RecipeIngredientsDTO();
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setRecOrIngrId(Randomizer.randomInt(1000));
		record.setRecipeFlg(Randomizer.randomString(2));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}