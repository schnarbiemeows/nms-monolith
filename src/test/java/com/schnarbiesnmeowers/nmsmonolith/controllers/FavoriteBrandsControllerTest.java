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

import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteBrandsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.FavoriteBrandsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.FavoriteBrandsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the FavoriteBrandsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class FavoriteBrandsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private FavoriteBrandsController favoritebrandsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private FavoriteBrandsService favoritebrandsService;

    @Mock
    private FavoriteBrandsRepository favoritebrandsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(favoritebrandsController).build();
    }

	/**
	 * test creating a new FavoriteBrands
	 * @throws 
	 */
	@Test
	public void testA_CreateFavoriteBrands() throws Exception
	{
	    FavoriteBrandsDTO favoritebrands = generateRandomFavoriteBrands();
        when(favoritebrandsService.createFavoriteBrands(any(FavoriteBrandsDTO.class))).thenReturn(favoritebrands);

        mockMvc.perform(post("/favoritebrands/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoritebrands)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all FavoriteBrands
	 * @throws 
	 */
	@Test
	public void testB_GetAllFavoriteBrands() throws Exception
	{
		List<FavoriteBrandsDTO> favoritebrandss = Arrays.asList(generateRandomFavoriteBrands(), generateRandomFavoriteBrands());
        when(favoritebrandsService.getAllFavoriteBrands()).thenReturn(favoritebrandss);

        mockMvc.perform(get("/favoritebrands/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single FavoriteBrands by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetFavoriteBrands() throws Exception
	{
		FavoriteBrandsDTO favoritebrands = generateRandomFavoriteBrands();
        when(favoritebrandsService.findFavoriteBrandsById(anyInt())).thenReturn(favoritebrands);

        mockMvc.perform(get("/favoritebrands/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a FavoriteBrands
	 * @throws 
	 */
	@Test
	public void testD_UpdateFavoriteBrands() throws Exception
	{
	    FavoriteBrandsDTO favoritebrands = generateRandomFavoriteBrands();
        when(favoritebrandsService.updateFavoriteBrands(any(FavoriteBrandsDTO.class))).thenReturn(favoritebrands);

        mockMvc.perform(post("/favoritebrands/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoritebrands)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a FavoriteBrands
	 * @throws 
	 */
	@Test
	public void testE_DeleteFavoriteBrands() throws Exception
	{
		when(favoritebrandsService.deleteFavoriteBrands(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/favoritebrands/delete/2"))
                .andExpect(status().isOk());
	}



	public static FavoriteBrandsDTO generateRandomFavoriteBrands() {
		FavoriteBrandsDTO record = new FavoriteBrandsDTO();
		record.setBrandId(Randomizer.randomInt(1000));
		record.setLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
}