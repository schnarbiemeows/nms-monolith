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

import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteSpicesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.FavoriteSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.FavoriteSpicesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the FavoriteSpicesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class FavoriteSpicesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private FavoriteSpicesController favoritespicesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private FavoriteSpicesService favoritespicesService;

    @Mock
    private FavoriteSpicesRepository favoritespicesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(favoritespicesController).build();
    }

	/**
	 * test creating a new FavoriteSpices
	 * @throws 
	 */
	@Test
	public void testA_CreateFavoriteSpices() throws Exception
	{
	    FavoriteSpicesDTO favoritespices = generateRandomFavoriteSpices();
        when(favoritespicesService.createFavoriteSpices(any(FavoriteSpicesDTO.class))).thenReturn(favoritespices);

        mockMvc.perform(post("/favoritespices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoritespices)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all FavoriteSpices
	 * @throws 
	 */
	@Test
	public void testB_GetAllFavoriteSpices() throws Exception
	{
		List<FavoriteSpicesDTO> favoritespicess = Arrays.asList(generateRandomFavoriteSpices(), generateRandomFavoriteSpices());
        when(favoritespicesService.getAllFavoriteSpices()).thenReturn(favoritespicess);

        mockMvc.perform(get("/favoritespices/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single FavoriteSpices by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetFavoriteSpices() throws Exception
	{
		FavoriteSpicesDTO favoritespices = generateRandomFavoriteSpices();
        when(favoritespicesService.findFavoriteSpicesById(anyInt())).thenReturn(favoritespices);

        mockMvc.perform(get("/favoritespices/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a FavoriteSpices
	 * @throws 
	 */
	@Test
	public void testD_UpdateFavoriteSpices() throws Exception
	{
	    FavoriteSpicesDTO favoritespices = generateRandomFavoriteSpices();
        when(favoritespicesService.updateFavoriteSpices(any(FavoriteSpicesDTO.class))).thenReturn(favoritespices);

        mockMvc.perform(post("/favoritespices/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoritespices)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a FavoriteSpices
	 * @throws 
	 */
	@Test
	public void testE_DeleteFavoriteSpices() throws Exception
	{
		when(favoritespicesService.deleteFavoriteSpices(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/favoritespices/delete/2"))
                .andExpect(status().isOk());
	}



	public static FavoriteSpicesDTO generateRandomFavoriteSpices() {
		FavoriteSpicesDTO record = new FavoriteSpicesDTO();
		record.setSpiceId(Randomizer.randomInt(1000));
		record.setIsLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
}