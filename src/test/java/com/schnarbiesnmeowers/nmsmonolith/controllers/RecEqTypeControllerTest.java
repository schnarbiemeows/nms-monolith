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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RecEqTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEqTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecEqTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecEqTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RecEqTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RecEqTypeController receqtypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RecEqTypeService receqtypeService;

    @Mock
    private RecEqTypeRepository receqtypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(receqtypeController).build();
    }

	/**
	 * test creating a new RecEqType
	 * @throws 
	 */
	@Test
	public void testA_CreateRecEqType() throws Exception
	{
	    RecEqTypeDTO receqtype = generateRandomRecEqType();
        when(receqtypeService.createRecEqType(any(RecEqTypeDTO.class))).thenReturn(receqtype);

        mockMvc.perform(post("/receqtype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(receqtype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RecEqType
	 * @throws 
	 */
	@Test
	public void testB_GetAllRecEqType() throws Exception
	{
		List<RecEqTypeDTO> receqtypes = Arrays.asList(generateRandomRecEqType(), generateRandomRecEqType());
        when(receqtypeService.getAllRecEqType()).thenReturn(receqtypes);

        mockMvc.perform(get("/receqtype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RecEqType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRecEqType() throws Exception
	{
		RecEqTypeDTO receqtype = generateRandomRecEqType();
        when(receqtypeService.findRecEqTypeById(anyInt())).thenReturn(receqtype);

        mockMvc.perform(get("/receqtype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RecEqType
	 * @throws 
	 */
	@Test
	public void testD_UpdateRecEqType() throws Exception
	{
	    RecEqTypeDTO receqtype = generateRandomRecEqType();
        when(receqtypeService.updateRecEqType(any(RecEqTypeDTO.class))).thenReturn(receqtype);

        mockMvc.perform(post("/receqtype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(receqtype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RecEqType
	 * @throws 
	 */
	@Test
	public void testE_DeleteRecEqType() throws Exception
	{
		when(receqtypeService.deleteRecEqType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/receqtype/delete/2"))
                .andExpect(status().isOk());
	}



	public static RecEqTypeDTO generateRandomRecEqType() {
		RecEqTypeDTO record = new RecEqTypeDTO();
		record.setRecEqCde(Randomizer.randomString(5));
		record.setRecEqDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}