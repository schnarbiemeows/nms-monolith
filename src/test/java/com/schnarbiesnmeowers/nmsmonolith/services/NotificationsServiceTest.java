package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.NotificationsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Notifications;
import com.schnarbiesnmeowers.nmsmonolith.repositories.NotificationsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class NotificationsServiceTest {

    @Mock
    private NotificationsRepository notificationsRepository;

    @InjectMocks
    private NotificationsService notificationsService;

    private Notifications notifications;
    private NotificationsDTO notificationsDTO;

    @BeforeEach
    void setUp() {
        notifications = generateRandomNotificationsEntity();
        notificationsDTO = generateRandomNotifications();
    }

    @Test
    void testGetAllNotifications() throws Exception {
        when(notificationsRepository.findAll()).thenReturn(Collections.singletonList(notifications));

        List<NotificationsDTO> result = notificationsService.getAllNotifications();

        assertEquals(1, result.size());
    }

    @Test
    void testFindNotificationsById_Found() throws Exception {
        when(notificationsRepository.findById(anyInt())).thenReturn(Optional.of(notifications));

        NotificationsDTO result = notificationsService.findNotificationsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindNotificationsById_NotFound() {
        when(notificationsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            notificationsService.findNotificationsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateNotifications() {
        when(notificationsRepository.save(any(Notifications.class))).thenReturn(notifications);

        NotificationsDTO result = notificationsService.createNotifications(notificationsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateNotifications_Found() throws Exception {
        when(notificationsRepository.findById(anyInt())).thenReturn(Optional.of(notifications));
        when(notificationsRepository.save(any(Notifications.class))).thenReturn(notifications);

        NotificationsDTO result = notificationsService.updateNotifications(notificationsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateNotifications_NotFound() {
        when(notificationsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            notificationsService.updateNotifications(notificationsDTO);
        });

        assertEquals("id = " + notificationsDTO.getNotificationId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteNotifications_Found() throws Exception {
        when(notificationsRepository.findById(anyInt())).thenReturn(Optional.of(notifications));
        doNothing().when(notificationsRepository).deleteById(anyInt());

        String result = notificationsService.deleteNotifications(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteNotifications_NotFound() {
        when(notificationsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            notificationsService.deleteNotifications(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static NotificationsDTO generateRandomNotifications() {
		NotificationsDTO record = new NotificationsDTO();
		record.setNotificationId(2);
		record.setEventId(Randomizer.randomInt(1000));
		record.setNotifTime(Randomizer.randomTime(1000));
		record.setNextNotifDate(Randomizer.randomDate());
		record.setDelivered(Randomizer.randomString(2));
		return record;
	}
    public static Notifications generateRandomNotificationsEntity() {
		Notifications record = new Notifications();
		record.setNotificationId(2);
		record.setEventId(Randomizer.randomInt(1000));
		record.setNotifTime(Randomizer.randomTime(1000));
		record.setNextNotifDate(Randomizer.randomDate());
		record.setDelivered(Randomizer.randomString(2));
		return record;
	}
}
