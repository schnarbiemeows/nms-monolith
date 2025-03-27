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

import com.schnarbiesnmeowers.nmsmonolith.repositories.ManualFoodItemsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ManualFoodItemsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ManualFoodItemsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ManualFoodItemsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ManualFoodItemsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private ManualFoodItemsController manualfooditemsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private ManualFoodItemsService manualfooditemsService;

    @Mock
    private ManualFoodItemsRepository manualfooditemsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(manualfooditemsController).build();
    }

	/**
	 * test creating a new ManualFoodItems
	 * @throws 
	 */
	@Test
	public void testA_CreateManualFoodItems() throws Exception
	{
	    ManualFoodItemsDTO manualfooditems = generateRandomManualFoodItems();
        when(manualfooditemsService.createManualFoodItems(any(ManualFoodItemsDTO.class))).thenReturn(manualfooditems);

        mockMvc.perform(post("/manualfooditems/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(manualfooditems)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all ManualFoodItems
	 * @throws 
	 */
	@Test
	public void testB_GetAllManualFoodItems() throws Exception
	{
		List<ManualFoodItemsDTO> manualfooditemss = Arrays.asList(generateRandomManualFoodItems(), generateRandomManualFoodItems());
        when(manualfooditemsService.getAllManualFoodItems()).thenReturn(manualfooditemss);

        mockMvc.perform(get("/manualfooditems/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single ManualFoodItems by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetManualFoodItems() throws Exception
	{
		ManualFoodItemsDTO manualfooditems = generateRandomManualFoodItems();
        when(manualfooditemsService.findManualFoodItemsById(anyInt())).thenReturn(manualfooditems);

        mockMvc.perform(get("/manualfooditems/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a ManualFoodItems
	 * @throws 
	 */
	@Test
	public void testD_UpdateManualFoodItems() throws Exception
	{
	    ManualFoodItemsDTO manualfooditems = generateRandomManualFoodItems();
        when(manualfooditemsService.updateManualFoodItems(any(ManualFoodItemsDTO.class))).thenReturn(manualfooditems);

        mockMvc.perform(post("/manualfooditems/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(manualfooditems)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a ManualFoodItems
	 * @throws 
	 */
	@Test
	public void testE_DeleteManualFoodItems() throws Exception
	{
		when(manualfooditemsService.deleteManualFoodItems(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/manualfooditems/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single ManualFoodItems by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<ManualFoodItemsDTO> manualfooditems = Arrays.asList(generateRandomManualFoodItems());
    when(manualfooditemsService.findManualFoodItemsByUserId(anyInt())).thenReturn(manualfooditems);

    mockMvc.perform(get("/manualfooditems/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single ManualFoodItems by field BldstId
 * @throws
 */
@Test
public void testC_findByBldstId() throws Exception
{
    List<ManualFoodItemsDTO> manualfooditems = Arrays.asList(generateRandomManualFoodItems());
    when(manualfooditemsService.findManualFoodItemsByBldstId(anyInt())).thenReturn(manualfooditems);

    mockMvc.perform(get("/manualfooditems/findByBldstId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single ManualFoodItems by field ServTypeId
 * @throws
 */
@Test
public void testC_findByServTypeId() throws Exception
{
    List<ManualFoodItemsDTO> manualfooditems = Arrays.asList(generateRandomManualFoodItems());
    when(manualfooditemsService.findManualFoodItemsByServTypeId(anyInt())).thenReturn(manualfooditems);

    mockMvc.perform(get("/manualfooditems/findByServTypeId/2"))
            .andExpect(status().isOk());
}

	public static ManualFoodItemsDTO generateRandomManualFoodItems() {
		ManualFoodItemsDTO record = new ManualFoodItemsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setIngrId(Randomizer.randomInt(1000));
		record.setIsRecipe(Randomizer.randomBoolean());
		record.setIsLocal(Randomizer.randomBoolean());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		return record;
	}
}