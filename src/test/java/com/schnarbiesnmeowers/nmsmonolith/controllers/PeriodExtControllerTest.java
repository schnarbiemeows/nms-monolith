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

import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodExtRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodExtDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PeriodExtService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PeriodExtController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class PeriodExtControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private PeriodExtController periodextController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private PeriodExtService periodextService;

    @Mock
    private PeriodExtRepository periodextRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(periodextController).build();
    }

	/**
	 * test creating a new PeriodExt
	 * @throws 
	 */
	@Test
	public void testA_CreatePeriodExt() throws Exception
	{
	    PeriodExtDTO periodext = generateRandomPeriodExt();
        when(periodextService.createPeriodExt(any(PeriodExtDTO.class))).thenReturn(periodext);

        mockMvc.perform(post("/periodext/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(periodext)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all PeriodExt
	 * @throws 
	 */
	@Test
	public void testB_GetAllPeriodExt() throws Exception
	{
		List<PeriodExtDTO> periodexts = Arrays.asList(generateRandomPeriodExt(), generateRandomPeriodExt());
        when(periodextService.getAllPeriodExt()).thenReturn(periodexts);

        mockMvc.perform(get("/periodext/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single PeriodExt by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetPeriodExt() throws Exception
	{
		PeriodExtDTO periodext = generateRandomPeriodExt();
        when(periodextService.findPeriodExtById(anyInt())).thenReturn(periodext);

        mockMvc.perform(get("/periodext/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a PeriodExt
	 * @throws 
	 */
	@Test
	public void testD_UpdatePeriodExt() throws Exception
	{
	    PeriodExtDTO periodext = generateRandomPeriodExt();
        when(periodextService.updatePeriodExt(any(PeriodExtDTO.class))).thenReturn(periodext);

        mockMvc.perform(post("/periodext/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(periodext)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a PeriodExt
	 * @throws 
	 */
	@Test
	public void testE_DeletePeriodExt() throws Exception
	{
		when(periodextService.deletePeriodExt(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/periodext/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single PeriodExt by field PeriodId
 * @throws
 */
@Test
public void testC_findByPeriodId() throws Exception
{
    List<PeriodExtDTO> periodext = Arrays.asList(generateRandomPeriodExt());
    when(periodextService.findPeriodExtByPeriodId(anyInt())).thenReturn(periodext);

    mockMvc.perform(get("/periodext/findByPeriodId/2"))
            .andExpect(status().isOk());
}

	public static PeriodExtDTO generateRandomPeriodExt() {
		PeriodExtDTO record = new PeriodExtDTO();
		record.setPeriodId(Randomizer.randomInt(1000));
		record.setSpecificDate(Randomizer.randomDate());
		record.setSpecificTime(Randomizer.randomTime(1000));
		return record;
	}
}