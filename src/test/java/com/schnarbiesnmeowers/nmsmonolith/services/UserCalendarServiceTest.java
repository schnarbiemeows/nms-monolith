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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserCalendarDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.UserCalendar;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UserCalendarRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class UserCalendarServiceTest {

    @Mock
    private UserCalendarRepository usercalendarRepository;

    @InjectMocks
    private UserCalendarService usercalendarService;

    private UserCalendar usercalendar;
    private UserCalendarDTO usercalendarDTO;

    @BeforeEach
    void setUp() {
        usercalendar = generateRandomUserCalendarEntity();
        usercalendarDTO = generateRandomUserCalendar();
    }

    @Test
    void testGetAllUserCalendar() throws Exception {
        when(usercalendarRepository.findAll()).thenReturn(Collections.singletonList(usercalendar));

        List<UserCalendarDTO> result = usercalendarService.getAllUserCalendar();

        assertEquals(1, result.size());
    }

    @Test
    void testFindUserCalendarById_Found() throws Exception {
        when(usercalendarRepository.findById(anyInt())).thenReturn(Optional.of(usercalendar));

        UserCalendarDTO result = usercalendarService.findUserCalendarById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindUserCalendarById_NotFound() {
        when(usercalendarRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usercalendarService.findUserCalendarById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateUserCalendar() {
        when(usercalendarRepository.save(any(UserCalendar.class))).thenReturn(usercalendar);

        UserCalendarDTO result = usercalendarService.createUserCalendar(usercalendarDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUserCalendar_Found() throws Exception {
        when(usercalendarRepository.findById(anyInt())).thenReturn(Optional.of(usercalendar));
        when(usercalendarRepository.save(any(UserCalendar.class))).thenReturn(usercalendar);

        UserCalendarDTO result = usercalendarService.updateUserCalendar(usercalendarDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUserCalendar_NotFound() {
        when(usercalendarRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usercalendarService.updateUserCalendar(usercalendarDTO);
        });

        assertEquals("id = " + usercalendarDTO.getUserCalendarId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteUserCalendar_Found() throws Exception {
        when(usercalendarRepository.findById(anyInt())).thenReturn(Optional.of(usercalendar));
        doNothing().when(usercalendarRepository).deleteById(anyInt());

        String result = usercalendarService.deleteUserCalendar(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteUserCalendar_NotFound() {
        when(usercalendarRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usercalendarService.deleteUserCalendar(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static UserCalendarDTO generateRandomUserCalendar() {
		UserCalendarDTO record = new UserCalendarDTO();
		record.setUserCalendarId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setCalendarTime(Randomizer.randomTime(1000));
		record.setEventId(Randomizer.randomInt(1000));
		return record;
	}
    public static UserCalendar generateRandomUserCalendarEntity() {
		UserCalendar record = new UserCalendar();
		record.setUserCalendarId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setCalendarTime(Randomizer.randomTime(1000));
		record.setEventId(Randomizer.randomInt(1000));
		return record;
	}
}
