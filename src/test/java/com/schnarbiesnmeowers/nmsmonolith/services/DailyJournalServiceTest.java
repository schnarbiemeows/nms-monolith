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
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyJournalDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyJournal;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyJournalRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class DailyJournalServiceTest {

    @Mock
    private DailyJournalRepository dailyjournalRepository;

    @InjectMocks
    private DailyJournalService dailyjournalService;

    private DailyJournal dailyjournal;
    private DailyJournalDTO dailyjournalDTO;

    @BeforeEach
    void setUp() {
        dailyjournal = generateRandomDailyJournalEntity();
        dailyjournalDTO = generateRandomDailyJournal();
    }

    @Test
    void testGetAllDailyJournal() throws Exception {
        when(dailyjournalRepository.findAll()).thenReturn(Collections.singletonList(dailyjournal));

        List<DailyJournalDTO> result = dailyjournalService.getAllDailyJournal();

        assertEquals(1, result.size());
    }

    @Test
    void testFindDailyJournalById_Found() throws Exception {
        when(dailyjournalRepository.findById(anyInt())).thenReturn(Optional.of(dailyjournal));

        DailyJournalDTO result = dailyjournalService.findDailyJournalById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindDailyJournalById_NotFound() {
        when(dailyjournalRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailyjournalService.findDailyJournalById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateDailyJournal() {
        when(dailyjournalRepository.save(any(DailyJournal.class))).thenReturn(dailyjournal);

        DailyJournalDTO result = dailyjournalService.createDailyJournal(dailyjournalDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyJournal_Found() throws Exception {
        when(dailyjournalRepository.findById(anyInt())).thenReturn(Optional.of(dailyjournal));
        when(dailyjournalRepository.save(any(DailyJournal.class))).thenReturn(dailyjournal);

        DailyJournalDTO result = dailyjournalService.updateDailyJournal(dailyjournalDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyJournal_NotFound() {
        when(dailyjournalRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailyjournalService.updateDailyJournal(dailyjournalDTO);
        });

        assertEquals("id = " + dailyjournalDTO.getDailyJournalId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteDailyJournal_Found() throws Exception {
        when(dailyjournalRepository.findById(anyInt())).thenReturn(Optional.of(dailyjournal));
        doNothing().when(dailyjournalRepository).deleteById(anyInt());

        String result = dailyjournalService.deleteDailyJournal(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteDailyJournal_NotFound() {
        when(dailyjournalRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailyjournalService.deleteDailyJournal(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static DailyJournalDTO generateRandomDailyJournal() {
		DailyJournalDTO record = new DailyJournalDTO();
		record.setDailyJournalId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setNote(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static DailyJournal generateRandomDailyJournalEntity() {
		DailyJournal record = new DailyJournal();
		record.setDailyJournalId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setNote(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
