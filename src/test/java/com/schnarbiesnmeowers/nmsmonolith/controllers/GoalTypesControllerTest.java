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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalTypesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalTypesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GoalTypesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GoalTypesController goaltypesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GoalTypesService goaltypesService;

    @Mock
    private GoalTypesRepository goaltypesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(goaltypesController).build();
    }

	/**
	 * test creating a new GoalTypes
	 * @throws 
	 */
	@Test
	public void testA_CreateGoalTypes() throws Exception
	{
	    GoalTypesDTO goaltypes = generateRandomGoalTypes();
        when(goaltypesService.createGoalTypes(any(GoalTypesDTO.class))).thenReturn(goaltypes);

        mockMvc.perform(post("/goaltypes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goaltypes)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GoalTypes
	 * @throws 
	 */
	@Test
	public void testB_GetAllGoalTypes() throws Exception
	{
		List<GoalTypesDTO> goaltypess = Arrays.asList(generateRandomGoalTypes(), generateRandomGoalTypes());
        when(goaltypesService.getAllGoalTypes()).thenReturn(goaltypess);

        mockMvc.perform(get("/goaltypes/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GoalTypes by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGoalTypes() throws Exception
	{
		GoalTypesDTO goaltypes = generateRandomGoalTypes();
        when(goaltypesService.findGoalTypesById(anyInt())).thenReturn(goaltypes);

        mockMvc.perform(get("/goaltypes/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GoalTypes
	 * @throws 
	 */
	@Test
	public void testD_UpdateGoalTypes() throws Exception
	{
	    GoalTypesDTO goaltypes = generateRandomGoalTypes();
        when(goaltypesService.updateGoalTypes(any(GoalTypesDTO.class))).thenReturn(goaltypes);

        mockMvc.perform(post("/goaltypes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goaltypes)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GoalTypes
	 * @throws 
	 */
	@Test
	public void testE_DeleteGoalTypes() throws Exception
	{
		when(goaltypesService.deleteGoalTypes(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/goaltypes/delete/2"))
                .andExpect(status().isOk());
	}



	public static GoalTypesDTO generateRandomGoalTypes() {
		GoalTypesDTO record = new GoalTypesDTO();
		record.setGoalTypeCde(Randomizer.randomString(3));
		record.setGoalTypeDesc(Randomizer.randomString(20));
		return record;
	}
}