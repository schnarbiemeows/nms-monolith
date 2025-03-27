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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GrpUserHistRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GrpUserHistService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GrpUserHistController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GrpUserHistControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GrpUserHistController grpuserhistController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GrpUserHistService grpuserhistService;

    @Mock
    private GrpUserHistRepository grpuserhistRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(grpuserhistController).build();
    }

	/**
	 * test creating a new GrpUserHist
	 * @throws 
	 */
	@Test
	public void testA_CreateGrpUserHist() throws Exception
	{
	    GrpUserHistDTO grpuserhist = generateRandomGrpUserHist();
        when(grpuserhistService.createGrpUserHist(any(GrpUserHistDTO.class))).thenReturn(grpuserhist);

        mockMvc.perform(post("/grpuserhist/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(grpuserhist)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GrpUserHist
	 * @throws 
	 */
	@Test
	public void testB_GetAllGrpUserHist() throws Exception
	{
		List<GrpUserHistDTO> grpuserhists = Arrays.asList(generateRandomGrpUserHist(), generateRandomGrpUserHist());
        when(grpuserhistService.getAllGrpUserHist()).thenReturn(grpuserhists);

        mockMvc.perform(get("/grpuserhist/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GrpUserHist by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGrpUserHist() throws Exception
	{
		GrpUserHistDTO grpuserhist = generateRandomGrpUserHist();
        when(grpuserhistService.findGrpUserHistById(anyInt())).thenReturn(grpuserhist);

        mockMvc.perform(get("/grpuserhist/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GrpUserHist
	 * @throws 
	 */
	@Test
	public void testD_UpdateGrpUserHist() throws Exception
	{
	    GrpUserHistDTO grpuserhist = generateRandomGrpUserHist();
        when(grpuserhistService.updateGrpUserHist(any(GrpUserHistDTO.class))).thenReturn(grpuserhist);

        mockMvc.perform(post("/grpuserhist/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(grpuserhist)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GrpUserHist
	 * @throws 
	 */
	@Test
	public void testE_DeleteGrpUserHist() throws Exception
	{
		when(grpuserhistService.deleteGrpUserHist(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/grpuserhist/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single GrpUserHist by field GrpUserId
 * @throws
 */
@Test
public void testC_findByGrpUserId() throws Exception
{
    List<GrpUserHistDTO> grpuserhist = Arrays.asList(generateRandomGrpUserHist());
    when(grpuserhistService.findGrpUserHistByGrpUserId(anyInt())).thenReturn(grpuserhist);

    mockMvc.perform(get("/grpuserhist/findByGrpUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GrpUserHist by field GrpId
 * @throws
 */
@Test
public void testC_findByGrpId() throws Exception
{
    List<GrpUserHistDTO> grpuserhist = Arrays.asList(generateRandomGrpUserHist());
    when(grpuserhistService.findGrpUserHistByGrpId(anyInt())).thenReturn(grpuserhist);

    mockMvc.perform(get("/grpuserhist/findByGrpId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GrpUserHist by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<GrpUserHistDTO> grpuserhist = Arrays.asList(generateRandomGrpUserHist());
    when(grpuserhistService.findGrpUserHistByUserId(anyInt())).thenReturn(grpuserhist);

    mockMvc.perform(get("/grpuserhist/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GrpUserHist by field ActionTypeId
 * @throws
 */
@Test
public void testC_findByActionTypeId() throws Exception
{
    List<GrpUserHistDTO> grpuserhist = Arrays.asList(generateRandomGrpUserHist());
    when(grpuserhistService.findGrpUserHistByActionTypeId(anyInt())).thenReturn(grpuserhist);

    mockMvc.perform(get("/grpuserhist/findByActionTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GrpUserHist by field EvntOperId
 * @throws
 */
@Test
public void testC_findByEvntOperId() throws Exception
{
    List<GrpUserHistDTO> grpuserhist = Arrays.asList(generateRandomGrpUserHist());
    when(grpuserhistService.findGrpUserHistByEvntOperId(anyInt())).thenReturn(grpuserhist);

    mockMvc.perform(get("/grpuserhist/findByEvntOperId/2"))
            .andExpect(status().isOk());
}

	public static GrpUserHistDTO generateRandomGrpUserHist() {
		GrpUserHistDTO record = new GrpUserHistDTO();
		record.setGrpUserId(Randomizer.randomInt(1000));
		record.setGrpId(Randomizer.randomInt(1000));
		record.setUserId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}