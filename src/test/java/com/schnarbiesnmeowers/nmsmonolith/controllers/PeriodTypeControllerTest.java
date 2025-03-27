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

import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PeriodTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PeriodTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class PeriodTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private PeriodTypeController periodtypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private PeriodTypeService periodtypeService;

    @Mock
    private PeriodTypeRepository periodtypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(periodtypeController).build();
    }

	/**
	 * test creating a new PeriodType
	 * @throws 
	 */
	@Test
	public void testA_CreatePeriodType() throws Exception
	{
	    PeriodTypeDTO periodtype = generateRandomPeriodType();
        when(periodtypeService.createPeriodType(any(PeriodTypeDTO.class))).thenReturn(periodtype);

        mockMvc.perform(post("/periodtype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(periodtype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all PeriodType
	 * @throws 
	 */
	@Test
	public void testB_GetAllPeriodType() throws Exception
	{
		List<PeriodTypeDTO> periodtypes = Arrays.asList(generateRandomPeriodType(), generateRandomPeriodType());
        when(periodtypeService.getAllPeriodType()).thenReturn(periodtypes);

        mockMvc.perform(get("/periodtype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single PeriodType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetPeriodType() throws Exception
	{
		PeriodTypeDTO periodtype = generateRandomPeriodType();
        when(periodtypeService.findPeriodTypeById(anyInt())).thenReturn(periodtype);

        mockMvc.perform(get("/periodtype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a PeriodType
	 * @throws 
	 */
	@Test
	public void testD_UpdatePeriodType() throws Exception
	{
	    PeriodTypeDTO periodtype = generateRandomPeriodType();
        when(periodtypeService.updatePeriodType(any(PeriodTypeDTO.class))).thenReturn(periodtype);

        mockMvc.perform(post("/periodtype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(periodtype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a PeriodType
	 * @throws 
	 */
	@Test
	public void testE_DeletePeriodType() throws Exception
	{
		when(periodtypeService.deletePeriodType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/periodtype/delete/2"))
                .andExpect(status().isOk());
	}



	public static PeriodTypeDTO generateRandomPeriodType() {
		PeriodTypeDTO record = new PeriodTypeDTO();
		record.setPeriodTypeCde(Randomizer.randomString(2));
		record.setPeriodTypeDesc(Randomizer.randomString(20));
		return record;
	}
}