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

import com.schnarbiesnmeowers.nmsmonolith.repositories.UsersHistRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UsersHistService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UsersHistController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class UsersHistControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private UsersHistController usershistController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private UsersHistService usershistService;

    @Mock
    private UsersHistRepository usershistRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(usershistController).build();
    }

	/**
	 * test creating a new UsersHist
	 * @throws 
	 */
	@Test
	public void testA_CreateUsersHist() throws Exception
	{
	    UsersHistDTO usershist = generateRandomUsersHist();
        when(usershistService.createUsersHist(any(UsersHistDTO.class))).thenReturn(usershist);

        mockMvc.perform(post("/usershist/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usershist)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all UsersHist
	 * @throws 
	 */
	@Test
	public void testB_GetAllUsersHist() throws Exception
	{
		List<UsersHistDTO> usershists = Arrays.asList(generateRandomUsersHist(), generateRandomUsersHist());
        when(usershistService.getAllUsersHist()).thenReturn(usershists);

        mockMvc.perform(get("/usershist/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single UsersHist by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetUsersHist() throws Exception
	{
		UsersHistDTO usershist = generateRandomUsersHist();
        when(usershistService.findUsersHistById(anyInt())).thenReturn(usershist);

        mockMvc.perform(get("/usershist/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a UsersHist
	 * @throws 
	 */
	@Test
	public void testD_UpdateUsersHist() throws Exception
	{
	    UsersHistDTO usershist = generateRandomUsersHist();
        when(usershistService.updateUsersHist(any(UsersHistDTO.class))).thenReturn(usershist);

        mockMvc.perform(post("/usershist/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usershist)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a UsersHist
	 * @throws 
	 */
	@Test
	public void testE_DeleteUsersHist() throws Exception
	{
		when(usershistService.deleteUsersHist(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/usershist/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single UsersHist by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<UsersHistDTO> usershist = Arrays.asList(generateRandomUsersHist());
    when(usershistService.findUsersHistByUserId(anyInt())).thenReturn(usershist);

    mockMvc.perform(get("/usershist/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single UsersHist by field ActionTypeId
 * @throws
 */
@Test
public void testC_findByActionTypeId() throws Exception
{
    List<UsersHistDTO> usershist = Arrays.asList(generateRandomUsersHist());
    when(usershistService.findUsersHistByActionTypeId(anyInt())).thenReturn(usershist);

    mockMvc.perform(get("/usershist/findByActionTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single UsersHist by field EvntOperId
 * @throws
 */
@Test
public void testC_findByEvntOperId() throws Exception
{
    List<UsersHistDTO> usershist = Arrays.asList(generateRandomUsersHist());
    when(usershistService.findUsersHistByEvntOperId(anyInt())).thenReturn(usershist);

    mockMvc.perform(get("/usershist/findByEvntOperId/2"))
            .andExpect(status().isOk());
}

	public static UsersHistDTO generateRandomUsersHist() {
		UsersHistDTO record = new UsersHistDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPassword(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setLstLogdIn(Randomizer.randomDate());
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}