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

import com.schnarbiesnmeowers.nmsmonolith.repositories.UsersRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UsersService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UsersController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private UsersController usersController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
    }

	/**
	 * test creating a new Users
	 * @throws 
	 */
	@Test
	public void testA_CreateUsers() throws Exception
	{
	    UsersDTO users = generateRandomUsers();
        when(usersService.createUsers(any(UsersDTO.class))).thenReturn(users);

        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(users)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Users
	 * @throws 
	 */
	@Test
	public void testB_GetAllUsers() throws Exception
	{
		List<UsersDTO> userss = Arrays.asList(generateRandomUsers(), generateRandomUsers());
        when(usersService.getAllUsers()).thenReturn(userss);

        mockMvc.perform(get("/users/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Users by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetUsers() throws Exception
	{
		UsersDTO users = generateRandomUsers();
        when(usersService.findUsersById(anyInt())).thenReturn(users);

        mockMvc.perform(get("/users/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Users
	 * @throws 
	 */
	@Test
	public void testD_UpdateUsers() throws Exception
	{
	    UsersDTO users = generateRandomUsers();
        when(usersService.updateUsers(any(UsersDTO.class))).thenReturn(users);

        mockMvc.perform(post("/users/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(users)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Users
	 * @throws 
	 */
	@Test
	public void testE_DeleteUsers() throws Exception
	{
		when(usersService.deleteUsers(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/users/delete/2"))
                .andExpect(status().isOk());
	}



	public static UsersDTO generateRandomUsers() {
		UsersDTO record = new UsersDTO();
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPassword(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setLstLogdIn(Randomizer.randomDate());
		record.setPhone(Randomizer.randomString(10));
		record.setActv(Randomizer.randomBoolean());
		String[] stringarray = new String[1];
		stringarray[0] = Randomizer.randomString(3);
		record.setAuthorizations(stringarray);
		record.setFirstName(Randomizer.randomString(20));
		record.setLastName(Randomizer.randomString(20));
		record.setUserNotLocked(Randomizer.randomBoolean());
		record.setJoinDate(Randomizer.randomDate());
		record.setLastLoginDateDisplay(Randomizer.randomDate());
		record.setProfileImage(Randomizer.randomString(20));
		record.setRoles(Randomizer.randomString(20));
		record.setUserIdentifier(Randomizer.randomString(20));
		return record;
	}
}