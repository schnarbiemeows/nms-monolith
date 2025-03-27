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

import com.schnarbiesnmeowers.nmsmonolith.repositories.LimitterSettingsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LimitterSettingsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LimitterSettingsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LimitterSettingsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class LimitterSettingsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private LimitterSettingsController limittersettingsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private LimitterSettingsService limittersettingsService;

    @Mock
    private LimitterSettingsRepository limittersettingsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(limittersettingsController).build();
    }

	/**
	 * test creating a new LimitterSettings
	 * @throws 
	 */
	@Test
	public void testA_CreateLimitterSettings() throws Exception
	{
	    LimitterSettingsDTO limittersettings = generateRandomLimitterSettings();
        when(limittersettingsService.createLimitterSettings(any(LimitterSettingsDTO.class))).thenReturn(limittersettings);

        mockMvc.perform(post("/limittersettings/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(limittersettings)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all LimitterSettings
	 * @throws 
	 */
	@Test
	public void testB_GetAllLimitterSettings() throws Exception
	{
		List<LimitterSettingsDTO> limittersettingss = Arrays.asList(generateRandomLimitterSettings(), generateRandomLimitterSettings());
        when(limittersettingsService.getAllLimitterSettings()).thenReturn(limittersettingss);

        mockMvc.perform(get("/limittersettings/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single LimitterSettings by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetLimitterSettings() throws Exception
	{
		LimitterSettingsDTO limittersettings = generateRandomLimitterSettings();
        when(limittersettingsService.findLimitterSettingsById(anyInt())).thenReturn(limittersettings);

        mockMvc.perform(get("/limittersettings/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a LimitterSettings
	 * @throws 
	 */
	@Test
	public void testD_UpdateLimitterSettings() throws Exception
	{
	    LimitterSettingsDTO limittersettings = generateRandomLimitterSettings();
        when(limittersettingsService.updateLimitterSettings(any(LimitterSettingsDTO.class))).thenReturn(limittersettings);

        mockMvc.perform(post("/limittersettings/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(limittersettings)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a LimitterSettings
	 * @throws 
	 */
	@Test
	public void testE_DeleteLimitterSettings() throws Exception
	{
		when(limittersettingsService.deleteLimitterSettings(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/limittersettings/delete/2"))
                .andExpect(status().isOk());
	}



	public static LimitterSettingsDTO generateRandomLimitterSettings() {
		LimitterSettingsDTO record = new LimitterSettingsDTO();
		record.setUrl(Randomizer.randomString(20));
		record.setDomain(Randomizer.randomString(20));
		record.setPermissions(Randomizer.randomString(20));
		record.setTotnumreqpersec(Randomizer.randomInt(1000));
		record.setWndwforratelmtinms(Randomizer.randomInt(1000));
		record.setTotalmaxbucketsize(Randomizer.randomInt(1000));
		record.setIptotnumreqpersec(Randomizer.randomInt(1000));
		record.setIpwndwrtlmt(Randomizer.randomInt(1000));
		record.setIpmaxwndw(Randomizer.randomInt(1000));
		record.setEnvironment(Randomizer.randomString(10));
		return record;
	}
}