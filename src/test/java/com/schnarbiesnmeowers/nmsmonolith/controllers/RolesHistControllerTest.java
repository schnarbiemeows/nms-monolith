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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RolesHistRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RolesHistService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RolesHistController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RolesHistControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RolesHistController roleshistController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RolesHistService roleshistService;

    @Mock
    private RolesHistRepository roleshistRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(roleshistController).build();
    }

	/**
	 * test creating a new RolesHist
	 * @throws 
	 */
	@Test
	public void testA_CreateRolesHist() throws Exception
	{
	    RolesHistDTO roleshist = generateRandomRolesHist();
        when(roleshistService.createRolesHist(any(RolesHistDTO.class))).thenReturn(roleshist);

        mockMvc.perform(post("/roleshist/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(roleshist)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RolesHist
	 * @throws 
	 */
	@Test
	public void testB_GetAllRolesHist() throws Exception
	{
		List<RolesHistDTO> roleshists = Arrays.asList(generateRandomRolesHist(), generateRandomRolesHist());
        when(roleshistService.getAllRolesHist()).thenReturn(roleshists);

        mockMvc.perform(get("/roleshist/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RolesHist by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRolesHist() throws Exception
	{
		RolesHistDTO roleshist = generateRandomRolesHist();
        when(roleshistService.findRolesHistById(anyInt())).thenReturn(roleshist);

        mockMvc.perform(get("/roleshist/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RolesHist
	 * @throws 
	 */
	@Test
	public void testD_UpdateRolesHist() throws Exception
	{
	    RolesHistDTO roleshist = generateRandomRolesHist();
        when(roleshistService.updateRolesHist(any(RolesHistDTO.class))).thenReturn(roleshist);

        mockMvc.perform(post("/roleshist/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(roleshist)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RolesHist
	 * @throws 
	 */
	@Test
	public void testE_DeleteRolesHist() throws Exception
	{
		when(roleshistService.deleteRolesHist(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/roleshist/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single RolesHist by field RoleId
 * @throws
 */
@Test
public void testC_findByRoleId() throws Exception
{
    List<RolesHistDTO> roleshist = Arrays.asList(generateRandomRolesHist());
    when(roleshistService.findRolesHistByRoleId(anyInt())).thenReturn(roleshist);

    mockMvc.perform(get("/roleshist/findByRoleId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single RolesHist by field GrpId
 * @throws
 */
@Test
public void testC_findByGrpId() throws Exception
{
    List<RolesHistDTO> roleshist = Arrays.asList(generateRandomRolesHist());
    when(roleshistService.findRolesHistByGrpId(anyInt())).thenReturn(roleshist);

    mockMvc.perform(get("/roleshist/findByGrpId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single RolesHist by field RsrcId
 * @throws
 */
@Test
public void testC_findByRsrcId() throws Exception
{
    List<RolesHistDTO> roleshist = Arrays.asList(generateRandomRolesHist());
    when(roleshistService.findRolesHistByRsrcId(anyInt())).thenReturn(roleshist);

    mockMvc.perform(get("/roleshist/findByRsrcId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single RolesHist by field ActionTypeId
 * @throws
 */
@Test
public void testC_findByActionTypeId() throws Exception
{
    List<RolesHistDTO> roleshist = Arrays.asList(generateRandomRolesHist());
    when(roleshistService.findRolesHistByActionTypeId(anyInt())).thenReturn(roleshist);

    mockMvc.perform(get("/roleshist/findByActionTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single RolesHist by field EvntOperId
 * @throws
 */
@Test
public void testC_findByEvntOperId() throws Exception
{
    List<RolesHistDTO> roleshist = Arrays.asList(generateRandomRolesHist());
    when(roleshistService.findRolesHistByEvntOperId(anyInt())).thenReturn(roleshist);

    mockMvc.perform(get("/roleshist/findByEvntOperId/2"))
            .andExpect(status().isOk());
}

	public static RolesHistDTO generateRandomRolesHist() {
		RolesHistDTO record = new RolesHistDTO();
		record.setRoleId(Randomizer.randomInt(1000));
		record.setGrpId(Randomizer.randomInt(1000));
		record.setRsrcId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}