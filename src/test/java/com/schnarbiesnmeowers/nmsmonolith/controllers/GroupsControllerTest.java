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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GroupsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GroupsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GroupsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GroupsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GroupsController groupsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GroupsService groupsService;

    @Mock
    private GroupsRepository groupsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(groupsController).build();
    }

	/**
	 * test creating a new Groups
	 * @throws 
	 */
	@Test
	public void testA_CreateGroups() throws Exception
	{
	    GroupsDTO groups = generateRandomGroups();
        when(groupsService.createGroups(any(GroupsDTO.class))).thenReturn(groups);

        mockMvc.perform(post("/groups/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(groups)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Groups
	 * @throws 
	 */
	@Test
	public void testB_GetAllGroups() throws Exception
	{
		List<GroupsDTO> groupss = Arrays.asList(generateRandomGroups(), generateRandomGroups());
        when(groupsService.getAllGroups()).thenReturn(groupss);

        mockMvc.perform(get("/groups/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Groups by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGroups() throws Exception
	{
		GroupsDTO groups = generateRandomGroups();
        when(groupsService.findGroupsById(anyInt())).thenReturn(groups);

        mockMvc.perform(get("/groups/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Groups
	 * @throws 
	 */
	@Test
	public void testD_UpdateGroups() throws Exception
	{
	    GroupsDTO groups = generateRandomGroups();
        when(groupsService.updateGroups(any(GroupsDTO.class))).thenReturn(groups);

        mockMvc.perform(post("/groups/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(groups)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Groups
	 * @throws 
	 */
	@Test
	public void testE_DeleteGroups() throws Exception
	{
		when(groupsService.deleteGroups(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/groups/delete/2"))
                .andExpect(status().isOk());
	}



	public static GroupsDTO generateRandomGroups() {
		GroupsDTO record = new GroupsDTO();
		record.setGrpName(Randomizer.randomString(20));
		record.setGrpDesc(Randomizer.randomString(20));
		return record;
	}
}