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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RsrcTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RsrcTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RsrcTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RsrcTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RsrcTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RsrcTypeController rsrctypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RsrcTypeService rsrctypeService;

    @Mock
    private RsrcTypeRepository rsrctypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(rsrctypeController).build();
    }

	/**
	 * test creating a new RsrcType
	 * @throws 
	 */
	@Test
	public void testA_CreateRsrcType() throws Exception
	{
	    RsrcTypeDTO rsrctype = generateRandomRsrcType();
        when(rsrctypeService.createRsrcType(any(RsrcTypeDTO.class))).thenReturn(rsrctype);

        mockMvc.perform(post("/rsrctype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rsrctype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RsrcType
	 * @throws 
	 */
	@Test
	public void testB_GetAllRsrcType() throws Exception
	{
		List<RsrcTypeDTO> rsrctypes = Arrays.asList(generateRandomRsrcType(), generateRandomRsrcType());
        when(rsrctypeService.getAllRsrcType()).thenReturn(rsrctypes);

        mockMvc.perform(get("/rsrctype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RsrcType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRsrcType() throws Exception
	{
		RsrcTypeDTO rsrctype = generateRandomRsrcType();
        when(rsrctypeService.findRsrcTypeById(anyInt())).thenReturn(rsrctype);

        mockMvc.perform(get("/rsrctype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RsrcType
	 * @throws 
	 */
	@Test
	public void testD_UpdateRsrcType() throws Exception
	{
	    RsrcTypeDTO rsrctype = generateRandomRsrcType();
        when(rsrctypeService.updateRsrcType(any(RsrcTypeDTO.class))).thenReturn(rsrctype);

        mockMvc.perform(post("/rsrctype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rsrctype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RsrcType
	 * @throws 
	 */
	@Test
	public void testE_DeleteRsrcType() throws Exception
	{
		when(rsrctypeService.deleteRsrcType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/rsrctype/delete/2"))
                .andExpect(status().isOk());
	}



	public static RsrcTypeDTO generateRandomRsrcType() {
		RsrcTypeDTO record = new RsrcTypeDTO();
		record.setRsrcType(Randomizer.randomString(20));
		record.setRsrcTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}