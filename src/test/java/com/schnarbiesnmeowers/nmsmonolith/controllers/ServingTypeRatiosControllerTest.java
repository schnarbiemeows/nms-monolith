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

import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypeRatiosRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ServingTypeRatiosService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ServingTypeRatiosController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ServingTypeRatiosControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private ServingTypeRatiosController servingtyperatiosController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private ServingTypeRatiosService servingtyperatiosService;

    @Mock
    private ServingTypeRatiosRepository servingtyperatiosRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(servingtyperatiosController).build();
    }

	/**
	 * test creating a new ServingTypeRatios
	 * @throws 
	 */
	@Test
	public void testA_CreateServingTypeRatios() throws Exception
	{
	    ServingTypeRatiosDTO servingtyperatios = generateRandomServingTypeRatios();
        when(servingtyperatiosService.createServingTypeRatios(any(ServingTypeRatiosDTO.class))).thenReturn(servingtyperatios);

        mockMvc.perform(post("/servingtyperatios/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servingtyperatios)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all ServingTypeRatios
	 * @throws 
	 */
	@Test
	public void testB_GetAllServingTypeRatios() throws Exception
	{
		List<ServingTypeRatiosDTO> servingtyperatioss = Arrays.asList(generateRandomServingTypeRatios(), generateRandomServingTypeRatios());
        when(servingtyperatiosService.getAllServingTypeRatios()).thenReturn(servingtyperatioss);

        mockMvc.perform(get("/servingtyperatios/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single ServingTypeRatios by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetServingTypeRatios() throws Exception
	{
		ServingTypeRatiosDTO servingtyperatios = generateRandomServingTypeRatios();
        when(servingtyperatiosService.findServingTypeRatiosById(anyInt())).thenReturn(servingtyperatios);

        mockMvc.perform(get("/servingtyperatios/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a ServingTypeRatios
	 * @throws 
	 */
	@Test
	public void testD_UpdateServingTypeRatios() throws Exception
	{
	    ServingTypeRatiosDTO servingtyperatios = generateRandomServingTypeRatios();
        when(servingtyperatiosService.updateServingTypeRatios(any(ServingTypeRatiosDTO.class))).thenReturn(servingtyperatios);

        mockMvc.perform(post("/servingtyperatios/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servingtyperatios)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a ServingTypeRatios
	 * @throws 
	 */
	@Test
	public void testE_DeleteServingTypeRatios() throws Exception
	{
		when(servingtyperatiosService.deleteServingTypeRatios(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/servingtyperatios/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single ServingTypeRatios by field ServTypeId1
 * @throws
 */
@Test
public void testC_findByServTypeId1() throws Exception
{
    List<ServingTypeRatiosDTO> servingtyperatios = Arrays.asList(generateRandomServingTypeRatios());
    when(servingtyperatiosService.findServingTypeRatiosByServTypeId1(anyInt())).thenReturn(servingtyperatios);

    mockMvc.perform(get("/servingtyperatios/findByServTypeId1/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single ServingTypeRatios by field ServTypeId2
 * @throws
 */
@Test
public void testC_findByServTypeId2() throws Exception
{
    List<ServingTypeRatiosDTO> servingtyperatios = Arrays.asList(generateRandomServingTypeRatios());
    when(servingtyperatiosService.findServingTypeRatiosByServTypeId2(anyInt())).thenReturn(servingtyperatios);

    mockMvc.perform(get("/servingtyperatios/findByServTypeId2/2"))
            .andExpect(status().isOk());
}

	public static ServingTypeRatiosDTO generateRandomServingTypeRatios() {
		ServingTypeRatiosDTO record = new ServingTypeRatiosDTO();
		record.setServTypeId1(Randomizer.randomInt(1000));
		record.setServTypeId2(Randomizer.randomInt(1000));
		record.setRatio(Randomizer.randomBigDecimal("1000"));
		return record;
	}
}