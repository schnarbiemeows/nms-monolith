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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalCategoriesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalCategoriesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalCategoriesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalCategoriesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GoalCategoriesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GoalCategoriesController goalcategoriesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GoalCategoriesService goalcategoriesService;

    @Mock
    private GoalCategoriesRepository goalcategoriesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(goalcategoriesController).build();
    }

	/**
	 * test creating a new GoalCategories
	 * @throws 
	 */
	@Test
	public void testA_CreateGoalCategories() throws Exception
	{
	    GoalCategoriesDTO goalcategories = generateRandomGoalCategories();
        when(goalcategoriesService.createGoalCategories(any(GoalCategoriesDTO.class))).thenReturn(goalcategories);

        mockMvc.perform(post("/goalcategories/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goalcategories)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GoalCategories
	 * @throws 
	 */
	@Test
	public void testB_GetAllGoalCategories() throws Exception
	{
		List<GoalCategoriesDTO> goalcategoriess = Arrays.asList(generateRandomGoalCategories(), generateRandomGoalCategories());
        when(goalcategoriesService.getAllGoalCategories()).thenReturn(goalcategoriess);

        mockMvc.perform(get("/goalcategories/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GoalCategories by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGoalCategories() throws Exception
	{
		GoalCategoriesDTO goalcategories = generateRandomGoalCategories();
        when(goalcategoriesService.findGoalCategoriesById(anyInt())).thenReturn(goalcategories);

        mockMvc.perform(get("/goalcategories/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GoalCategories
	 * @throws 
	 */
	@Test
	public void testD_UpdateGoalCategories() throws Exception
	{
	    GoalCategoriesDTO goalcategories = generateRandomGoalCategories();
        when(goalcategoriesService.updateGoalCategories(any(GoalCategoriesDTO.class))).thenReturn(goalcategories);

        mockMvc.perform(post("/goalcategories/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goalcategories)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GoalCategories
	 * @throws 
	 */
	@Test
	public void testE_DeleteGoalCategories() throws Exception
	{
		when(goalcategoriesService.deleteGoalCategories(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/goalcategories/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single GoalCategories by field GoalTypeId
 * @throws
 */
@Test
public void testC_findByGoalTypeId() throws Exception
{
    List<GoalCategoriesDTO> goalcategories = Arrays.asList(generateRandomGoalCategories());
    when(goalcategoriesService.findGoalCategoriesByGoalTypeId(anyInt())).thenReturn(goalcategories);

    mockMvc.perform(get("/goalcategories/findByGoalTypeId/2"))
            .andExpect(status().isOk());
}

	public static GoalCategoriesDTO generateRandomGoalCategories() {
		GoalCategoriesDTO record = new GoalCategoriesDTO();
		record.setGoalTypeId(Randomizer.randomInt(1000));
		record.setGcDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}