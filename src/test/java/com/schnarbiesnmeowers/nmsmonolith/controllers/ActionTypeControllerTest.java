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

import com.schnarbiesnmeowers.nmsmonolith.repositories.ActionTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ActionTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ActionTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ActionTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ActionTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private ActionTypeController actiontypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private ActionTypeService actiontypeService;

    @Mock
    private ActionTypeRepository actiontypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(actiontypeController).build();
    }

	/**
	 * test creating a new ActionType
	 * @throws 
	 */
	@Test
	public void testA_CreateActionType() throws Exception
	{
	    ActionTypeDTO actiontype = generateRandomActionType();
        when(actiontypeService.createActionType(any(ActionTypeDTO.class))).thenReturn(actiontype);

        mockMvc.perform(post("/actiontype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(actiontype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all ActionType
	 * @throws 
	 */
	@Test
	public void testB_GetAllActionType() throws Exception
	{
		List<ActionTypeDTO> actiontypes = Arrays.asList(generateRandomActionType(), generateRandomActionType());
        when(actiontypeService.getAllActionType()).thenReturn(actiontypes);

        mockMvc.perform(get("/actiontype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single ActionType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetActionType() throws Exception
	{
		ActionTypeDTO actiontype = generateRandomActionType();
        when(actiontypeService.findActionTypeById(anyInt())).thenReturn(actiontype);

        mockMvc.perform(get("/actiontype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a ActionType
	 * @throws 
	 */
	@Test
	public void testD_UpdateActionType() throws Exception
	{
	    ActionTypeDTO actiontype = generateRandomActionType();
        when(actiontypeService.updateActionType(any(ActionTypeDTO.class))).thenReturn(actiontype);

        mockMvc.perform(post("/actiontype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(actiontype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a ActionType
	 * @throws 
	 */
	@Test
	public void testE_DeleteActionType() throws Exception
	{
		when(actiontypeService.deleteActionType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/actiontype/delete/2"))
                .andExpect(status().isOk());
	}



	public static ActionTypeDTO generateRandomActionType() {
		ActionTypeDTO record = new ActionTypeDTO();
		record.setActionTypeCde(Randomizer.randomString(5));
		record.setActionTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}