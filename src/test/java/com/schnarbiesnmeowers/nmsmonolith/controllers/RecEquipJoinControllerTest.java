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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RecEquipJoinRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEquipJoinDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecEquipJoinService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecEquipJoinController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RecEquipJoinControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RecEquipJoinController recequipjoinController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RecEquipJoinService recequipjoinService;

    @Mock
    private RecEquipJoinRepository recequipjoinRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(recequipjoinController).build();
    }

	/**
	 * test creating a new RecEquipJoin
	 * @throws 
	 */
	@Test
	public void testA_CreateRecEquipJoin() throws Exception
	{
	    RecEquipJoinDTO recequipjoin = generateRandomRecEquipJoin();
        when(recequipjoinService.createRecEquipJoin(any(RecEquipJoinDTO.class))).thenReturn(recequipjoin);

        mockMvc.perform(post("/recequipjoin/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recequipjoin)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RecEquipJoin
	 * @throws 
	 */
	@Test
	public void testB_GetAllRecEquipJoin() throws Exception
	{
		List<RecEquipJoinDTO> recequipjoins = Arrays.asList(generateRandomRecEquipJoin(), generateRandomRecEquipJoin());
        when(recequipjoinService.getAllRecEquipJoin()).thenReturn(recequipjoins);

        mockMvc.perform(get("/recequipjoin/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RecEquipJoin by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRecEquipJoin() throws Exception
	{
		RecEquipJoinDTO recequipjoin = generateRandomRecEquipJoin();
        when(recequipjoinService.findRecEquipJoinById(anyInt())).thenReturn(recequipjoin);

        mockMvc.perform(get("/recequipjoin/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RecEquipJoin
	 * @throws 
	 */
	@Test
	public void testD_UpdateRecEquipJoin() throws Exception
	{
	    RecEquipJoinDTO recequipjoin = generateRandomRecEquipJoin();
        when(recequipjoinService.updateRecEquipJoin(any(RecEquipJoinDTO.class))).thenReturn(recequipjoin);

        mockMvc.perform(post("/recequipjoin/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recequipjoin)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RecEquipJoin
	 * @throws 
	 */
	@Test
	public void testE_DeleteRecEquipJoin() throws Exception
	{
		when(recequipjoinService.deleteRecEquipJoin(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/recequipjoin/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single RecEquipJoin by field RecipeId
 * @throws
 */
@Test
public void testC_findByRecipeId() throws Exception
{
    List<RecEquipJoinDTO> recequipjoin = Arrays.asList(generateRandomRecEquipJoin());
    when(recequipjoinService.findRecEquipJoinByRecipeId(anyInt())).thenReturn(recequipjoin);

    mockMvc.perform(get("/recequipjoin/findByRecipeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single RecEquipJoin by field RecipeEquipId
 * @throws
 */
@Test
public void testC_findByRecipeEquipId() throws Exception
{
    List<RecEquipJoinDTO> recequipjoin = Arrays.asList(generateRandomRecEquipJoin());
    when(recequipjoinService.findRecEquipJoinByRecipeEquipId(anyInt())).thenReturn(recequipjoin);

    mockMvc.perform(get("/recequipjoin/findByRecipeEquipId/2"))
            .andExpect(status().isOk());
}

	public static RecEquipJoinDTO generateRandomRecEquipJoin() {
		RecEquipJoinDTO record = new RecEquipJoinDTO();
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setRecipeEquipId(Randomizer.randomInt(1000));
		return record;
	}
}