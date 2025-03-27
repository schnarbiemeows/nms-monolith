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

import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteIngredientsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.FavoriteIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.FavoriteIngredientsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the FavoriteIngredientsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class FavoriteIngredientsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private FavoriteIngredientsController favoriteingredientsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private FavoriteIngredientsService favoriteingredientsService;

    @Mock
    private FavoriteIngredientsRepository favoriteingredientsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(favoriteingredientsController).build();
    }

	/**
	 * test creating a new FavoriteIngredients
	 * @throws 
	 */
	@Test
	public void testA_CreateFavoriteIngredients() throws Exception
	{
	    FavoriteIngredientsDTO favoriteingredients = generateRandomFavoriteIngredients();
        when(favoriteingredientsService.createFavoriteIngredients(any(FavoriteIngredientsDTO.class))).thenReturn(favoriteingredients);

        mockMvc.perform(post("/favoriteingredients/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoriteingredients)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all FavoriteIngredients
	 * @throws 
	 */
	@Test
	public void testB_GetAllFavoriteIngredients() throws Exception
	{
		List<FavoriteIngredientsDTO> favoriteingredientss = Arrays.asList(generateRandomFavoriteIngredients(), generateRandomFavoriteIngredients());
        when(favoriteingredientsService.getAllFavoriteIngredients()).thenReturn(favoriteingredientss);

        mockMvc.perform(get("/favoriteingredients/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single FavoriteIngredients by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetFavoriteIngredients() throws Exception
	{
		FavoriteIngredientsDTO favoriteingredients = generateRandomFavoriteIngredients();
        when(favoriteingredientsService.findFavoriteIngredientsById(anyInt())).thenReturn(favoriteingredients);

        mockMvc.perform(get("/favoriteingredients/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a FavoriteIngredients
	 * @throws 
	 */
	@Test
	public void testD_UpdateFavoriteIngredients() throws Exception
	{
	    FavoriteIngredientsDTO favoriteingredients = generateRandomFavoriteIngredients();
        when(favoriteingredientsService.updateFavoriteIngredients(any(FavoriteIngredientsDTO.class))).thenReturn(favoriteingredients);

        mockMvc.perform(post("/favoriteingredients/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoriteingredients)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a FavoriteIngredients
	 * @throws 
	 */
	@Test
	public void testE_DeleteFavoriteIngredients() throws Exception
	{
		when(favoriteingredientsService.deleteFavoriteIngredients(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/favoriteingredients/delete/2"))
                .andExpect(status().isOk());
	}



	public static FavoriteIngredientsDTO generateRandomFavoriteIngredients() {
		FavoriteIngredientsDTO record = new FavoriteIngredientsDTO();
		record.setIngrId(Randomizer.randomInt(1000));
		record.setLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
}