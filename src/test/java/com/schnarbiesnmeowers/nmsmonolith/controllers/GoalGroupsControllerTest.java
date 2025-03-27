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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalGroupsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalGroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalGroupsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalGroupsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GoalGroupsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GoalGroupsController goalgroupsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GoalGroupsService goalgroupsService;

    @Mock
    private GoalGroupsRepository goalgroupsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(goalgroupsController).build();
    }

	/**
	 * test creating a new GoalGroups
	 * @throws 
	 */
	@Test
	public void testA_CreateGoalGroups() throws Exception
	{
	    GoalGroupsDTO goalgroups = generateRandomGoalGroups();
        when(goalgroupsService.createGoalGroups(any(GoalGroupsDTO.class))).thenReturn(goalgroups);

        mockMvc.perform(post("/goalgroups/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goalgroups)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GoalGroups
	 * @throws 
	 */
	@Test
	public void testB_GetAllGoalGroups() throws Exception
	{
		List<GoalGroupsDTO> goalgroupss = Arrays.asList(generateRandomGoalGroups(), generateRandomGoalGroups());
        when(goalgroupsService.getAllGoalGroups()).thenReturn(goalgroupss);

        mockMvc.perform(get("/goalgroups/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GoalGroups by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGoalGroups() throws Exception
	{
		GoalGroupsDTO goalgroups = generateRandomGoalGroups();
        when(goalgroupsService.findGoalGroupsById(anyInt())).thenReturn(goalgroups);

        mockMvc.perform(get("/goalgroups/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GoalGroups
	 * @throws 
	 */
	@Test
	public void testD_UpdateGoalGroups() throws Exception
	{
	    GoalGroupsDTO goalgroups = generateRandomGoalGroups();
        when(goalgroupsService.updateGoalGroups(any(GoalGroupsDTO.class))).thenReturn(goalgroups);

        mockMvc.perform(post("/goalgroups/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goalgroups)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GoalGroups
	 * @throws 
	 */
	@Test
	public void testE_DeleteGoalGroups() throws Exception
	{
		when(goalgroupsService.deleteGoalGroups(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/goalgroups/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single GoalGroups by field GoalId1
 * @throws
 */
@Test
public void testC_findByGoalId1() throws Exception
{
    List<GoalGroupsDTO> goalgroups = Arrays.asList(generateRandomGoalGroups());
    when(goalgroupsService.findGoalGroupsByGoalId1(anyInt())).thenReturn(goalgroups);

    mockMvc.perform(get("/goalgroups/findByGoalId1/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GoalGroups by field GoalId2
 * @throws
 */
@Test
public void testC_findByGoalId2() throws Exception
{
    List<GoalGroupsDTO> goalgroups = Arrays.asList(generateRandomGoalGroups());
    when(goalgroupsService.findGoalGroupsByGoalId2(anyInt())).thenReturn(goalgroups);

    mockMvc.perform(get("/goalgroups/findByGoalId2/2"))
            .andExpect(status().isOk());
}

	public static GoalGroupsDTO generateRandomGoalGroups() {
		GoalGroupsDTO record = new GoalGroupsDTO();
		record.setGoalId1(Randomizer.randomInt(1000));
		record.setGoalId2(Randomizer.randomInt(1000));
		record.setRelation(Randomizer.randomString(3));
		return record;
	}
}