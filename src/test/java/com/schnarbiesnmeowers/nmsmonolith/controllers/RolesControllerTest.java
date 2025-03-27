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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RolesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RolesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RolesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RolesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RolesController rolesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RolesService rolesService;

    @Mock
    private RolesRepository rolesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(rolesController).build();
    }

	/**
	 * test creating a new Roles
	 * @throws 
	 */
	@Test
	public void testA_CreateRoles() throws Exception
	{
	    RolesDTO roles = generateRandomRoles();
        when(rolesService.createRoles(any(RolesDTO.class))).thenReturn(roles);

        mockMvc.perform(post("/roles/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(roles)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Roles
	 * @throws 
	 */
	@Test
	public void testB_GetAllRoles() throws Exception
	{
		List<RolesDTO> roless = Arrays.asList(generateRandomRoles(), generateRandomRoles());
        when(rolesService.getAllRoles()).thenReturn(roless);

        mockMvc.perform(get("/roles/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Roles by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRoles() throws Exception
	{
		RolesDTO roles = generateRandomRoles();
        when(rolesService.findRolesById(anyInt())).thenReturn(roles);

        mockMvc.perform(get("/roles/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Roles
	 * @throws 
	 */
	@Test
	public void testD_UpdateRoles() throws Exception
	{
	    RolesDTO roles = generateRandomRoles();
        when(rolesService.updateRoles(any(RolesDTO.class))).thenReturn(roles);

        mockMvc.perform(post("/roles/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(roles)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Roles
	 * @throws 
	 */
	@Test
	public void testE_DeleteRoles() throws Exception
	{
		when(rolesService.deleteRoles(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/roles/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Roles by field GrpId
 * @throws
 */
@Test
public void testC_findByGrpId() throws Exception
{
    List<RolesDTO> roles = Arrays.asList(generateRandomRoles());
    when(rolesService.findRolesByGrpId(anyInt())).thenReturn(roles);

    mockMvc.perform(get("/roles/findByGrpId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Roles by field RsrcId
 * @throws
 */
@Test
public void testC_findByRsrcId() throws Exception
{
    List<RolesDTO> roles = Arrays.asList(generateRandomRoles());
    when(rolesService.findRolesByRsrcId(anyInt())).thenReturn(roles);

    mockMvc.perform(get("/roles/findByRsrcId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Roles by field ActionTypeId
 * @throws
 */
@Test
public void testC_findByActionTypeId() throws Exception
{
    List<RolesDTO> roles = Arrays.asList(generateRandomRoles());
    when(rolesService.findRolesByActionTypeId(anyInt())).thenReturn(roles);

    mockMvc.perform(get("/roles/findByActionTypeId/2"))
            .andExpect(status().isOk());
}

	public static RolesDTO generateRandomRoles() {
		RolesDTO record = new RolesDTO();
		record.setGrpId(Randomizer.randomInt(1000));
		record.setRsrcId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		return record;
	}
}