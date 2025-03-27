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

import com.schnarbiesnmeowers.nmsmonolith.repositories.UserTempRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserTempDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UserTempService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UserTempController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class UserTempControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private UserTempController usertempController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private UserTempService usertempService;

    @Mock
    private UserTempRepository usertempRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(usertempController).build();
    }

	/**
	 * test creating a new UserTemp
	 * @throws 
	 */
	@Test
	public void testA_CreateUserTemp() throws Exception
	{
	    UserTempDTO usertemp = generateRandomUserTemp();
        when(usertempService.createUserTemp(any(UserTempDTO.class))).thenReturn(usertemp);

        mockMvc.perform(post("/usertemp/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usertemp)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all UserTemp
	 * @throws 
	 */
	@Test
	public void testB_GetAllUserTemp() throws Exception
	{
		List<UserTempDTO> usertemps = Arrays.asList(generateRandomUserTemp(), generateRandomUserTemp());
        when(usertempService.getAllUserTemp()).thenReturn(usertemps);

        mockMvc.perform(get("/usertemp/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single UserTemp by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetUserTemp() throws Exception
	{
		UserTempDTO usertemp = generateRandomUserTemp();
        when(usertempService.findUserTempById(anyInt())).thenReturn(usertemp);

        mockMvc.perform(get("/usertemp/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a UserTemp
	 * @throws 
	 */
	@Test
	public void testD_UpdateUserTemp() throws Exception
	{
	    UserTempDTO usertemp = generateRandomUserTemp();
        when(usertempService.updateUserTemp(any(UserTempDTO.class))).thenReturn(usertemp);

        mockMvc.perform(post("/usertemp/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usertemp)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a UserTemp
	 * @throws 
	 */
	@Test
	public void testE_DeleteUserTemp() throws Exception
	{
		when(usertempService.deleteUserTemp(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/usertemp/delete/2"))
                .andExpect(status().isOk());
	}



	public static UserTempDTO generateRandomUserTemp() {
		UserTempDTO record = new UserTempDTO();
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPhone(Randomizer.randomString(10));
		record.setFirstName(Randomizer.randomString(20));
		record.setLastName(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomBoolean());
		String[] stringarray = new String[1];
		stringarray[0] = Randomizer.randomString(3);
		record.setAuthorizations(stringarray);
		record.setUserNotLocked(Randomizer.randomBoolean());
		record.setCreatedDate(Randomizer.randomDate());
		record.setJoinDate(Randomizer.randomDate());
		record.setLastLoginDate(Randomizer.randomDate());
		record.setLastLoginDateDisplay(Randomizer.randomDate());
		record.setPassword(Randomizer.randomString(20));
		record.setProfileImage(Randomizer.randomString(20));
		record.setRoles(Randomizer.randomString(20));
		record.setUserIdentifier(Randomizer.randomString(20));
		record.setUniqueId(Randomizer.randomString(20));
		return record;
	}
}