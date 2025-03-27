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

import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteRecipesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.FavoriteRecipesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.FavoriteRecipesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the FavoriteRecipesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class FavoriteRecipesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private FavoriteRecipesController favoriterecipesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private FavoriteRecipesService favoriterecipesService;

    @Mock
    private FavoriteRecipesRepository favoriterecipesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(favoriterecipesController).build();
    }

	/**
	 * test creating a new FavoriteRecipes
	 * @throws 
	 */
	@Test
	public void testA_CreateFavoriteRecipes() throws Exception
	{
	    FavoriteRecipesDTO favoriterecipes = generateRandomFavoriteRecipes();
        when(favoriterecipesService.createFavoriteRecipes(any(FavoriteRecipesDTO.class))).thenReturn(favoriterecipes);

        mockMvc.perform(post("/favoriterecipes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoriterecipes)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all FavoriteRecipes
	 * @throws 
	 */
	@Test
	public void testB_GetAllFavoriteRecipes() throws Exception
	{
		List<FavoriteRecipesDTO> favoriterecipess = Arrays.asList(generateRandomFavoriteRecipes(), generateRandomFavoriteRecipes());
        when(favoriterecipesService.getAllFavoriteRecipes()).thenReturn(favoriterecipess);

        mockMvc.perform(get("/favoriterecipes/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single FavoriteRecipes by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetFavoriteRecipes() throws Exception
	{
		FavoriteRecipesDTO favoriterecipes = generateRandomFavoriteRecipes();
        when(favoriterecipesService.findFavoriteRecipesById(anyInt())).thenReturn(favoriterecipes);

        mockMvc.perform(get("/favoriterecipes/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a FavoriteRecipes
	 * @throws 
	 */
	@Test
	public void testD_UpdateFavoriteRecipes() throws Exception
	{
	    FavoriteRecipesDTO favoriterecipes = generateRandomFavoriteRecipes();
        when(favoriterecipesService.updateFavoriteRecipes(any(FavoriteRecipesDTO.class))).thenReturn(favoriterecipes);

        mockMvc.perform(post("/favoriterecipes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoriterecipes)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a FavoriteRecipes
	 * @throws 
	 */
	@Test
	public void testE_DeleteFavoriteRecipes() throws Exception
	{
		when(favoriterecipesService.deleteFavoriteRecipes(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/favoriterecipes/delete/2"))
                .andExpect(status().isOk());
	}



	public static FavoriteRecipesDTO generateRandomFavoriteRecipes() {
		FavoriteRecipesDTO record = new FavoriteRecipesDTO();
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
}