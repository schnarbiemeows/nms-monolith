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

import com.schnarbiesnmeowers.nmsmonolith.repositories.UserCalendarRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserCalendarDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UserCalendarService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UserCalendarController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class UserCalendarControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private UserCalendarController usercalendarController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private UserCalendarService usercalendarService;

    @Mock
    private UserCalendarRepository usercalendarRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(usercalendarController).build();
    }

	/**
	 * test creating a new UserCalendar
	 * @throws 
	 */
	@Test
	public void testA_CreateUserCalendar() throws Exception
	{
	    UserCalendarDTO usercalendar = generateRandomUserCalendar();
        when(usercalendarService.createUserCalendar(any(UserCalendarDTO.class))).thenReturn(usercalendar);

        mockMvc.perform(post("/usercalendar/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usercalendar)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all UserCalendar
	 * @throws 
	 */
	@Test
	public void testB_GetAllUserCalendar() throws Exception
	{
		List<UserCalendarDTO> usercalendars = Arrays.asList(generateRandomUserCalendar(), generateRandomUserCalendar());
        when(usercalendarService.getAllUserCalendar()).thenReturn(usercalendars);

        mockMvc.perform(get("/usercalendar/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single UserCalendar by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetUserCalendar() throws Exception
	{
		UserCalendarDTO usercalendar = generateRandomUserCalendar();
        when(usercalendarService.findUserCalendarById(anyInt())).thenReturn(usercalendar);

        mockMvc.perform(get("/usercalendar/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a UserCalendar
	 * @throws 
	 */
	@Test
	public void testD_UpdateUserCalendar() throws Exception
	{
	    UserCalendarDTO usercalendar = generateRandomUserCalendar();
        when(usercalendarService.updateUserCalendar(any(UserCalendarDTO.class))).thenReturn(usercalendar);

        mockMvc.perform(post("/usercalendar/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usercalendar)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a UserCalendar
	 * @throws 
	 */
	@Test
	public void testE_DeleteUserCalendar() throws Exception
	{
		when(usercalendarService.deleteUserCalendar(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/usercalendar/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single UserCalendar by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<UserCalendarDTO> usercalendar = Arrays.asList(generateRandomUserCalendar());
    when(usercalendarService.findUserCalendarByUserId(anyInt())).thenReturn(usercalendar);

    mockMvc.perform(get("/usercalendar/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single UserCalendar by field EventId
 * @throws
 */
@Test
public void testC_findByEventId() throws Exception
{
    List<UserCalendarDTO> usercalendar = Arrays.asList(generateRandomUserCalendar());
    when(usercalendarService.findUserCalendarByEventId(anyInt())).thenReturn(usercalendar);

    mockMvc.perform(get("/usercalendar/findByEventId/2"))
            .andExpect(status().isOk());
}

	public static UserCalendarDTO generateRandomUserCalendar() {
		UserCalendarDTO record = new UserCalendarDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setCalendarTime(Randomizer.randomTime(1000));
		record.setEventId(Randomizer.randomInt(1000));
		return record;
	}
}