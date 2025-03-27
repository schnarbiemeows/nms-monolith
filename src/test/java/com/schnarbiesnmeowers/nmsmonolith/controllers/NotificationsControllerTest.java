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

import com.schnarbiesnmeowers.nmsmonolith.repositories.NotificationsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.NotificationsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.NotificationsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the NotificationsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class NotificationsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private NotificationsController notificationsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private NotificationsService notificationsService;

    @Mock
    private NotificationsRepository notificationsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(notificationsController).build();
    }

	/**
	 * test creating a new Notifications
	 * @throws 
	 */
	@Test
	public void testA_CreateNotifications() throws Exception
	{
	    NotificationsDTO notifications = generateRandomNotifications();
        when(notificationsService.createNotifications(any(NotificationsDTO.class))).thenReturn(notifications);

        mockMvc.perform(post("/notifications/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notifications)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Notifications
	 * @throws 
	 */
	@Test
	public void testB_GetAllNotifications() throws Exception
	{
		List<NotificationsDTO> notificationss = Arrays.asList(generateRandomNotifications(), generateRandomNotifications());
        when(notificationsService.getAllNotifications()).thenReturn(notificationss);

        mockMvc.perform(get("/notifications/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Notifications by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetNotifications() throws Exception
	{
		NotificationsDTO notifications = generateRandomNotifications();
        when(notificationsService.findNotificationsById(anyInt())).thenReturn(notifications);

        mockMvc.perform(get("/notifications/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Notifications
	 * @throws 
	 */
	@Test
	public void testD_UpdateNotifications() throws Exception
	{
	    NotificationsDTO notifications = generateRandomNotifications();
        when(notificationsService.updateNotifications(any(NotificationsDTO.class))).thenReturn(notifications);

        mockMvc.perform(post("/notifications/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notifications)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Notifications
	 * @throws 
	 */
	@Test
	public void testE_DeleteNotifications() throws Exception
	{
		when(notificationsService.deleteNotifications(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/notifications/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Notifications by field EventId
 * @throws
 */
@Test
public void testC_findByEventId() throws Exception
{
    List<NotificationsDTO> notifications = Arrays.asList(generateRandomNotifications());
    when(notificationsService.findNotificationsByEventId(anyInt())).thenReturn(notifications);

    mockMvc.perform(get("/notifications/findByEventId/2"))
            .andExpect(status().isOk());
}

	public static NotificationsDTO generateRandomNotifications() {
		NotificationsDTO record = new NotificationsDTO();
		record.setEventId(Randomizer.randomInt(1000));
		record.setNotifTime(Randomizer.randomTime(1000));
		record.setNextNotifDate(Randomizer.randomDate());
		record.setDelivered(Randomizer.randomString(2));
		return record;
	}
}