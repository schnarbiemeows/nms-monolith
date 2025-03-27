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

import com.schnarbiesnmeowers.nmsmonolith.repositories.UserConfigRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserConfigDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UserConfigService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UserConfigController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class UserConfigControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private UserConfigController userconfigController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private UserConfigService userconfigService;

    @Mock
    private UserConfigRepository userconfigRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(userconfigController).build();
    }

	/**
	 * test creating a new UserConfig
	 * @throws 
	 */
	@Test
	public void testA_CreateUserConfig() throws Exception
	{
	    UserConfigDTO userconfig = generateRandomUserConfig();
        when(userconfigService.createUserConfig(any(UserConfigDTO.class))).thenReturn(userconfig);

        mockMvc.perform(post("/userconfig/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userconfig)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all UserConfig
	 * @throws 
	 */
	@Test
	public void testB_GetAllUserConfig() throws Exception
	{
		List<UserConfigDTO> userconfigs = Arrays.asList(generateRandomUserConfig(), generateRandomUserConfig());
        when(userconfigService.getAllUserConfig()).thenReturn(userconfigs);

        mockMvc.perform(get("/userconfig/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single UserConfig by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetUserConfig() throws Exception
	{
		UserConfigDTO userconfig = generateRandomUserConfig();
        when(userconfigService.findUserConfigById(anyInt())).thenReturn(userconfig);

        mockMvc.perform(get("/userconfig/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a UserConfig
	 * @throws 
	 */
	@Test
	public void testD_UpdateUserConfig() throws Exception
	{
	    UserConfigDTO userconfig = generateRandomUserConfig();
        when(userconfigService.updateUserConfig(any(UserConfigDTO.class))).thenReturn(userconfig);

        mockMvc.perform(post("/userconfig/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userconfig)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a UserConfig
	 * @throws 
	 */
	@Test
	public void testE_DeleteUserConfig() throws Exception
	{
		when(userconfigService.deleteUserConfig(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/userconfig/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single UserConfig by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<UserConfigDTO> userconfig = Arrays.asList(generateRandomUserConfig());
    when(userconfigService.findUserConfigByUserId(anyInt())).thenReturn(userconfig);

    mockMvc.perform(get("/userconfig/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static UserConfigDTO generateRandomUserConfig() {
		UserConfigDTO record = new UserConfigDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setPropertyKey(Randomizer.randomString(20));
		record.setPropertyValue(Randomizer.randomString(20));
		return record;
	}
}