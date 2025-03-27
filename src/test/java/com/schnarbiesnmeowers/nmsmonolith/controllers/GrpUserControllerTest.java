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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GrpUserRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GrpUserService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GrpUserController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GrpUserControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GrpUserController grpuserController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GrpUserService grpuserService;

    @Mock
    private GrpUserRepository grpuserRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(grpuserController).build();
    }

	/**
	 * test creating a new GrpUser
	 * @throws 
	 */
	@Test
	public void testA_CreateGrpUser() throws Exception
	{
	    GrpUserDTO grpuser = generateRandomGrpUser();
        when(grpuserService.createGrpUser(any(GrpUserDTO.class))).thenReturn(grpuser);

        mockMvc.perform(post("/grpuser/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(grpuser)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GrpUser
	 * @throws 
	 */
	@Test
	public void testB_GetAllGrpUser() throws Exception
	{
		List<GrpUserDTO> grpusers = Arrays.asList(generateRandomGrpUser(), generateRandomGrpUser());
        when(grpuserService.getAllGrpUser()).thenReturn(grpusers);

        mockMvc.perform(get("/grpuser/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GrpUser by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGrpUser() throws Exception
	{
		GrpUserDTO grpuser = generateRandomGrpUser();
        when(grpuserService.findGrpUserById(anyInt())).thenReturn(grpuser);

        mockMvc.perform(get("/grpuser/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GrpUser
	 * @throws 
	 */
	@Test
	public void testD_UpdateGrpUser() throws Exception
	{
	    GrpUserDTO grpuser = generateRandomGrpUser();
        when(grpuserService.updateGrpUser(any(GrpUserDTO.class))).thenReturn(grpuser);

        mockMvc.perform(post("/grpuser/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(grpuser)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GrpUser
	 * @throws 
	 */
	@Test
	public void testE_DeleteGrpUser() throws Exception
	{
		when(grpuserService.deleteGrpUser(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/grpuser/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single GrpUser by field GrpId
 * @throws
 */
@Test
public void testC_findByGrpId() throws Exception
{
    List<GrpUserDTO> grpuser = Arrays.asList(generateRandomGrpUser());
    when(grpuserService.findGrpUserByGrpId(anyInt())).thenReturn(grpuser);

    mockMvc.perform(get("/grpuser/findByGrpId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GrpUser by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<GrpUserDTO> grpuser = Arrays.asList(generateRandomGrpUser());
    when(grpuserService.findGrpUserByUserId(anyInt())).thenReturn(grpuser);

    mockMvc.perform(get("/grpuser/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static GrpUserDTO generateRandomGrpUser() {
		GrpUserDTO record = new GrpUserDTO();
		record.setGrpId(Randomizer.randomInt(1000));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
}