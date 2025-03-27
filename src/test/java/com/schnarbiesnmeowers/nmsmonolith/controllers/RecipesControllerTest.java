package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipesRepository;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RecipesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RecipesController recipesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RecipesService recipesService;

    @Mock
    private RecipesRepository recipesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(recipesController).build();
    }

	/**
	 * test creating a new Recipes
	 * @throws 
	 */
	@Test
	public void testA_CreateRecipes() throws Exception
	{
	    RecipesDTO recipes = generateRandomRecipes();
        when(recipesService.createRecipe(any(RecipeFormDTO.class))).thenReturn(recipes);

        mockMvc.perform(post("/recipes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipes)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Recipes
	 * @throws 
	 */
	@Test
	public void testB_GetAllRecipes() throws Exception
	{
		List<RecipesDTO> recipess = Arrays.asList(generateRandomRecipes(), generateRandomRecipes());
        when(recipesService.getAllRecipes()).thenReturn(recipess);

        mockMvc.perform(get("/recipes/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Recipes by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRecipes() throws Exception
	{
		RecipeFormDTO recipeForm = generateRandomRecipeForm();
        when(recipesService.findRecipesById(anyInt())).thenReturn(recipeForm);

        mockMvc.perform(get("/recipes/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Recipes
	 * @throws 
	 */
	@Test
	public void testD_UpdateRecipes() throws Exception
	{
	    RecipesDTO recipes = generateRandomRecipes();

        when(recipesService.updateRecipe(any(RecipeFormDTO.class))).thenReturn(recipes);

        mockMvc.perform(post("/recipes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipes)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Recipes
	 * @throws 
	 */
	@Test
	public void testE_DeleteRecipes() throws Exception
	{
		when(recipesService.deleteRecipe(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/recipes/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Recipes by field IngrId
 * @throws
 */
@Test
public void testC_findByIngrId() throws Exception
{
    List<RecipesDTO> recipes = Arrays.asList(generateRandomRecipes());
    when(recipesService.findRecipesByIngrId(anyInt())).thenReturn(recipes);

    mockMvc.perform(get("/recipes/findByIngrId/2"))
            .andExpect(status().isOk());
}

	public static RecipesDTO generateRandomRecipes() {
		RecipesDTO record = new RecipesDTO();
		record.setRecipeName(Randomizer.randomString(20));
		record.setRecipeTypeId(Randomizer.randomInt(1000));
		record.setIngrId(Randomizer.randomInt(1000));
		record.setRecipeDesc(Randomizer.randomString(20));
		record.setRecipeLink(Randomizer.randomString(20));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

	public static RecipeFormDTO generateRandomRecipeForm() {
		RecipeFormDTO dto = new RecipeFormDTO();
		dto.setRecipeMetaData(generateRandomRecipes());
		dto.setLocal(false);
		dto.setServingSize(BigDecimal.ONE);
		dto.setServingTypeId(Randomizer.randomInt(1000));
		dto.setUserId(Randomizer.randomInt(1000));
		dto.setRecipeIngredients(new ArrayList<>());
		dto.setRecipeSpices(new ArrayList<>());
		dto.setRecipeSteps(new ArrayList<>());
		dto.setFavor(true);
		return dto;
	}
}