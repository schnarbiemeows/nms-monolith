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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RdaRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RdaDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RdaService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RdaController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RdaControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RdaController rdaController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RdaService rdaService;

    @Mock
    private RdaRepository rdaRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(rdaController).build();
    }

	/**
	 * test creating a new Rda
	 * @throws 
	 */
	@Test
	public void testA_CreateRda() throws Exception
	{
	    RdaDTO rda = generateRandomRda();
        when(rdaService.createRda(any(RdaDTO.class))).thenReturn(rda);

        mockMvc.perform(post("/rda/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rda)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Rda
	 * @throws 
	 */
	@Test
	public void testB_GetAllRda() throws Exception
	{
		List<RdaDTO> rdas = Arrays.asList(generateRandomRda(), generateRandomRda());
        when(rdaService.getAllRda()).thenReturn(rdas);

        mockMvc.perform(get("/rda/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Rda by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRda() throws Exception
	{
		RdaDTO rda = generateRandomRda();
        when(rdaService.findRdaById(anyInt())).thenReturn(rda);

        mockMvc.perform(get("/rda/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Rda
	 * @throws 
	 */
	@Test
	public void testD_UpdateRda() throws Exception
	{
	    RdaDTO rda = generateRandomRda();
        when(rdaService.updateRda(any(RdaDTO.class))).thenReturn(rda);

        mockMvc.perform(post("/rda/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rda)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Rda
	 * @throws 
	 */
	@Test
	public void testE_DeleteRda() throws Exception
	{
		when(rdaService.deleteRda(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/rda/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Rda by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<RdaDTO> rda = Arrays.asList(generateRandomRda());
    when(rdaService.findRdaByUserId(anyInt())).thenReturn(rda);

    mockMvc.perform(get("/rda/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static RdaDTO generateRandomRda() {
		RdaDTO record = new RdaDTO();
		record.setRdaName(Randomizer.randomString(20));
		record.setRdaValue(Randomizer.randomBigDecimal("1000"));
		record.setUserId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}