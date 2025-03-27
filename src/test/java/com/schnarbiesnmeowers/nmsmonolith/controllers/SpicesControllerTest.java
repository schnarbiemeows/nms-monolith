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

import com.schnarbiesnmeowers.nmsmonolith.repositories.SpicesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.SpicesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the SpicesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class SpicesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private SpicesController spicesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private SpicesService spicesService;

    @Mock
    private SpicesRepository spicesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(spicesController).build();
    }

	/**
	 * test creating a new Spices
	 * @throws 
	 */
	@Test
	public void testA_CreateSpices() throws Exception
	{
	    SpicesDTO spices = generateRandomSpices();
        when(spicesService.createSpices(any(SpicesDTO.class))).thenReturn(spices);

        mockMvc.perform(post("/spices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(spices)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Spices
	 * @throws 
	 */
	@Test
	public void testB_GetAllSpices() throws Exception
	{
		List<SpicesDTO> spicess = Arrays.asList(generateRandomSpices(), generateRandomSpices());
        when(spicesService.getAllSpices()).thenReturn(spicess);

        mockMvc.perform(get("/spices/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Spices by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetSpices() throws Exception
	{
		SpicesDTO spices = generateRandomSpices();
        when(spicesService.findSpicesById(anyInt())).thenReturn(spices);

        mockMvc.perform(get("/spices/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Spices
	 * @throws 
	 */
	@Test
	public void testD_UpdateSpices() throws Exception
	{
	    SpicesDTO spices = generateRandomSpices();
        when(spicesService.updateSpices(any(SpicesDTO.class))).thenReturn(spices);

        mockMvc.perform(post("/spices/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(spices)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Spices
	 * @throws 
	 */
	@Test
	public void testE_DeleteSpices() throws Exception
	{
		when(spicesService.deleteSpices(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/spices/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Spices by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<SpicesDTO> spices = Arrays.asList(generateRandomSpices());
    when(spicesService.findSpicesByImageLoc(anyInt())).thenReturn(spices);

    mockMvc.perform(get("/spices/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static SpicesDTO generateRandomSpices() {
		SpicesDTO record = new SpicesDTO();
		record.setSpiceName(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		record.setImageLoc(Randomizer.randomInt(1000));
		return record;
	}
}