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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GroupsHistRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GroupsHistService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GroupsHistController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GroupsHistControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GroupsHistController groupshistController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GroupsHistService groupshistService;

    @Mock
    private GroupsHistRepository groupshistRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(groupshistController).build();
    }

	/**
	 * test creating a new GroupsHist
	 * @throws 
	 */
	@Test
	public void testA_CreateGroupsHist() throws Exception
	{
	    GroupsHistDTO groupshist = generateRandomGroupsHist();
        when(groupshistService.createGroupsHist(any(GroupsHistDTO.class))).thenReturn(groupshist);

        mockMvc.perform(post("/groupshist/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(groupshist)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GroupsHist
	 * @throws 
	 */
	@Test
	public void testB_GetAllGroupsHist() throws Exception
	{
		List<GroupsHistDTO> groupshists = Arrays.asList(generateRandomGroupsHist(), generateRandomGroupsHist());
        when(groupshistService.getAllGroupsHist()).thenReturn(groupshists);

        mockMvc.perform(get("/groupshist/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GroupsHist by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGroupsHist() throws Exception
	{
		GroupsHistDTO groupshist = generateRandomGroupsHist();
        when(groupshistService.findGroupsHistById(anyInt())).thenReturn(groupshist);

        mockMvc.perform(get("/groupshist/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GroupsHist
	 * @throws 
	 */
	@Test
	public void testD_UpdateGroupsHist() throws Exception
	{
	    GroupsHistDTO groupshist = generateRandomGroupsHist();
        when(groupshistService.updateGroupsHist(any(GroupsHistDTO.class))).thenReturn(groupshist);

        mockMvc.perform(post("/groupshist/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(groupshist)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GroupsHist
	 * @throws 
	 */
	@Test
	public void testE_DeleteGroupsHist() throws Exception
	{
		when(groupshistService.deleteGroupsHist(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/groupshist/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single GroupsHist by field GrpId
 * @throws
 */
@Test
public void testC_findByGrpId() throws Exception
{
    List<GroupsHistDTO> groupshist = Arrays.asList(generateRandomGroupsHist());
    when(groupshistService.findGroupsHistByGrpId(anyInt())).thenReturn(groupshist);

    mockMvc.perform(get("/groupshist/findByGrpId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GroupsHist by field ActionTypeId
 * @throws
 */
@Test
public void testC_findByActionTypeId() throws Exception
{
    List<GroupsHistDTO> groupshist = Arrays.asList(generateRandomGroupsHist());
    when(groupshistService.findGroupsHistByActionTypeId(anyInt())).thenReturn(groupshist);

    mockMvc.perform(get("/groupshist/findByActionTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GroupsHist by field EvntOperId
 * @throws
 */
@Test
public void testC_findByEvntOperId() throws Exception
{
    List<GroupsHistDTO> groupshist = Arrays.asList(generateRandomGroupsHist());
    when(groupshistService.findGroupsHistByEvntOperId(anyInt())).thenReturn(groupshist);

    mockMvc.perform(get("/groupshist/findByEvntOperId/2"))
            .andExpect(status().isOk());
}

	public static GroupsHistDTO generateRandomGroupsHist() {
		GroupsHistDTO record = new GroupsHistDTO();
		record.setGrpId(Randomizer.randomInt(1000));
		record.setGrpName(Randomizer.randomString(20));
		record.setGrpDesc(Randomizer.randomString(20));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}