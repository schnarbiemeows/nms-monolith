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

import com.schnarbiesnmeowers.nmsmonolith.repositories.BodyMeasurementsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BodyMeasurementsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.BodyMeasurementsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the BodyMeasurementsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class BodyMeasurementsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private BodyMeasurementsController bodymeasurementsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private BodyMeasurementsService bodymeasurementsService;

    @Mock
    private BodyMeasurementsRepository bodymeasurementsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(bodymeasurementsController).build();
    }

	/**
	 * test creating a new BodyMeasurements
	 * @throws 
	 */
	@Test
	public void testA_CreateBodyMeasurements() throws Exception
	{
	    BodyMeasurementsDTO bodymeasurements = generateRandomBodyMeasurements();
        when(bodymeasurementsService.createBodyMeasurements(any(BodyMeasurementsDTO.class))).thenReturn(bodymeasurements);

        mockMvc.perform(post("/bodymeasurements/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bodymeasurements)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all BodyMeasurements
	 * @throws 
	 */
	@Test
	public void testB_GetAllBodyMeasurements() throws Exception
	{
		List<BodyMeasurementsDTO> bodymeasurementss = Arrays.asList(generateRandomBodyMeasurements(), generateRandomBodyMeasurements());
        when(bodymeasurementsService.getAllBodyMeasurements()).thenReturn(bodymeasurementss);

        mockMvc.perform(get("/bodymeasurements/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single BodyMeasurements by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetBodyMeasurements() throws Exception
	{
		BodyMeasurementsDTO bodymeasurements = generateRandomBodyMeasurements();
        when(bodymeasurementsService.findBodyMeasurementsById(anyInt())).thenReturn(bodymeasurements);

        mockMvc.perform(get("/bodymeasurements/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a BodyMeasurements
	 * @throws 
	 */
	@Test
	public void testD_UpdateBodyMeasurements() throws Exception
	{
	    BodyMeasurementsDTO bodymeasurements = generateRandomBodyMeasurements();
        when(bodymeasurementsService.updateBodyMeasurements(any(BodyMeasurementsDTO.class))).thenReturn(bodymeasurements);

        mockMvc.perform(post("/bodymeasurements/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bodymeasurements)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a BodyMeasurements
	 * @throws 
	 */
	@Test
	public void testE_DeleteBodyMeasurements() throws Exception
	{
		when(bodymeasurementsService.deleteBodyMeasurements(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/bodymeasurements/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single BodyMeasurements by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<BodyMeasurementsDTO> bodymeasurements = Arrays.asList(generateRandomBodyMeasurements());
    when(bodymeasurementsService.findBodyMeasurementsByUserId(anyInt())).thenReturn(bodymeasurements);

    mockMvc.perform(get("/bodymeasurements/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static BodyMeasurementsDTO generateRandomBodyMeasurements() {
		BodyMeasurementsDTO record = new BodyMeasurementsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomLocalDate());
		record.setLeftCalf(Randomizer.randomBigDecimal("1000"));
		record.setRightCalf(Randomizer.randomBigDecimal("1000"));
		record.setLeftThigh(Randomizer.randomBigDecimal("1000"));
		record.setRightThigh(Randomizer.randomBigDecimal("1000"));
		record.setWaist(Randomizer.randomBigDecimal("1000"));
		record.setChest(Randomizer.randomBigDecimal("1000"));
		record.setLeftBicep(Randomizer.randomBigDecimal("1000"));
		record.setRightBicep(Randomizer.randomBigDecimal("1000"));
		record.setLeftForearm(Randomizer.randomBigDecimal("1000"));
		record.setRightForearm(Randomizer.randomBigDecimal("1000"));
		record.setShoulders(Randomizer.randomBigDecimal("1000"));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}