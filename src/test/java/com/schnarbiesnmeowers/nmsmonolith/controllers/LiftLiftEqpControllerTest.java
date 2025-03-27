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

import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftLiftEqpRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftLiftEqpDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftLiftEqpService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftLiftEqpController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class LiftLiftEqpControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private LiftLiftEqpController liftlifteqpController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private LiftLiftEqpService liftlifteqpService;

    @Mock
    private LiftLiftEqpRepository liftlifteqpRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(liftlifteqpController).build();
    }

	/**
	 * test creating a new LiftLiftEqp
	 * @throws 
	 */
	@Test
	public void testA_CreateLiftLiftEqp() throws Exception
	{
	    LiftLiftEqpDTO liftlifteqp = generateRandomLiftLiftEqp();
        when(liftlifteqpService.createLiftLiftEqp(any(LiftLiftEqpDTO.class))).thenReturn(liftlifteqp);

        mockMvc.perform(post("/liftlifteqp/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftlifteqp)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all LiftLiftEqp
	 * @throws 
	 */
	@Test
	public void testB_GetAllLiftLiftEqp() throws Exception
	{
		List<LiftLiftEqpDTO> liftlifteqps = Arrays.asList(generateRandomLiftLiftEqp(), generateRandomLiftLiftEqp());
        when(liftlifteqpService.getAllLiftLiftEqp()).thenReturn(liftlifteqps);

        mockMvc.perform(get("/liftlifteqp/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single LiftLiftEqp by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetLiftLiftEqp() throws Exception
	{
		LiftLiftEqpDTO liftlifteqp = generateRandomLiftLiftEqp();
        when(liftlifteqpService.findLiftLiftEqpById(anyInt())).thenReturn(liftlifteqp);

        mockMvc.perform(get("/liftlifteqp/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a LiftLiftEqp
	 * @throws 
	 */
	@Test
	public void testD_UpdateLiftLiftEqp() throws Exception
	{
	    LiftLiftEqpDTO liftlifteqp = generateRandomLiftLiftEqp();
        when(liftlifteqpService.updateLiftLiftEqp(any(LiftLiftEqpDTO.class))).thenReturn(liftlifteqp);

        mockMvc.perform(post("/liftlifteqp/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftlifteqp)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a LiftLiftEqp
	 * @throws 
	 */
	@Test
	public void testE_DeleteLiftLiftEqp() throws Exception
	{
		when(liftlifteqpService.deleteLiftLiftEqp(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/liftlifteqp/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single LiftLiftEqp by field LiftId
 * @throws
 */
@Test
public void testC_findByLiftId() throws Exception
{
    List<LiftLiftEqpDTO> liftlifteqp = Arrays.asList(generateRandomLiftLiftEqp());
    when(liftlifteqpService.findLiftLiftEqpByLiftId(anyInt())).thenReturn(liftlifteqp);

    mockMvc.perform(get("/liftlifteqp/findByLiftId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single LiftLiftEqp by field LiftEquipId
 * @throws
 */
@Test
public void testC_findByLiftEquipId() throws Exception
{
    List<LiftLiftEqpDTO> liftlifteqp = Arrays.asList(generateRandomLiftLiftEqp());
    when(liftlifteqpService.findLiftLiftEqpByLiftEquipId(anyInt())).thenReturn(liftlifteqp);

    mockMvc.perform(get("/liftlifteqp/findByLiftEquipId/2"))
            .andExpect(status().isOk());
}

	public static LiftLiftEqpDTO generateRandomLiftLiftEqp() {
		LiftLiftEqpDTO record = new LiftLiftEqpDTO();
		record.setLiftId(Randomizer.randomInt(1000));
		record.setLiftEquipId(Randomizer.randomInt(1000));
		return record;
	}
}