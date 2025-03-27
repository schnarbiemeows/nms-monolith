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

import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftEquipRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftEquipDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftEquipService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftEquipController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class LiftEquipControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private LiftEquipController liftequipController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private LiftEquipService liftequipService;

    @Mock
    private LiftEquipRepository liftequipRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(liftequipController).build();
    }

	/**
	 * test creating a new LiftEquip
	 * @throws 
	 */
	@Test
	public void testA_CreateLiftEquip() throws Exception
	{
	    LiftEquipDTO liftequip = generateRandomLiftEquip();
        when(liftequipService.createLiftEquip(any(LiftEquipDTO.class))).thenReturn(liftequip);

        mockMvc.perform(post("/liftequip/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftequip)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all LiftEquip
	 * @throws 
	 */
	@Test
	public void testB_GetAllLiftEquip() throws Exception
	{
		List<LiftEquipDTO> liftequips = Arrays.asList(generateRandomLiftEquip(), generateRandomLiftEquip());
        when(liftequipService.getAllLiftEquip()).thenReturn(liftequips);

        mockMvc.perform(get("/liftequip/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single LiftEquip by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetLiftEquip() throws Exception
	{
		LiftEquipDTO liftequip = generateRandomLiftEquip();
        when(liftequipService.findLiftEquipById(anyInt())).thenReturn(liftequip);

        mockMvc.perform(get("/liftequip/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a LiftEquip
	 * @throws 
	 */
	@Test
	public void testD_UpdateLiftEquip() throws Exception
	{
	    LiftEquipDTO liftequip = generateRandomLiftEquip();
        when(liftequipService.updateLiftEquip(any(LiftEquipDTO.class))).thenReturn(liftequip);

        mockMvc.perform(post("/liftequip/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftequip)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a LiftEquip
	 * @throws 
	 */
	@Test
	public void testE_DeleteLiftEquip() throws Exception
	{
		when(liftequipService.deleteLiftEquip(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/liftequip/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single LiftEquip by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<LiftEquipDTO> liftequip = Arrays.asList(generateRandomLiftEquip());
    when(liftequipService.findLiftEquipByImageLoc(anyInt())).thenReturn(liftequip);

    mockMvc.perform(get("/liftequip/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static LiftEquipDTO generateRandomLiftEquip() {
		LiftEquipDTO record = new LiftEquipDTO();
		record.setEquipDesc(Randomizer.randomString(20));
		record.setEquipLongDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}