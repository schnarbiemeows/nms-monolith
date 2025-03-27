package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietWrapper;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import com.schnarbiesnmeowers.nmsmonolith.utilities.BldstUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDiet;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class DailyDietServiceTest {

    private static final Logger log = LoggerFactory.getLogger(DailyDietServiceTest.class);
    @Mock
    private DailyDietRepository dailydietRepository;

    @Mock
    private DailyDietaryNotesService dailyDietaryNotesService;

    @Mock
    private BldstUtility bldstUtility;

    @Mock
    DailyDietaryExclusionsService dailyDietaryExclusionsService;

    @Mock
    UsersService usersService;

    @Mock
    UnsyncedService unsyncedService;

    @InjectMocks
    private DailyDietService dailydietService;

    private DailyDiet dailydiet;
    private DailyDietDTO dailydietDTO;

    @BeforeEach
    void setUp() {
        dailydiet = generateRandomDailyDietEntity();
        dailydietDTO = generateRandomDailyDiet();
    }

    @Test
    void testGetAllDailyDiet() throws Exception {
        when(dailydietRepository.findAll()).thenReturn(Collections.singletonList(dailydiet));

        List<DailyDietDTO> result = dailydietService.getAllDailyDiet();

        assertEquals(1, result.size());
    }

    @Test
    void testFindDailyDietById_Found() throws Exception {
        when(dailydietRepository.findById(anyInt())).thenReturn(Optional.of(dailydiet));

        DailyDietDTO result = dailydietService.findDailyDietById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindDailyDietById_NotFound() {
        when(dailydietRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietService.findDailyDietById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateDailyDiet() throws Exception {
        when(dailydietRepository.save(any(DailyDiet.class))).thenReturn(dailydiet);
        when(dailydietRepository.findDailyDietByUserIdAndDate(
                anyInt(),any()))
                .thenReturn(Collections.emptyList());
        when(dailyDietaryNotesService
                .findDailyDietaryNotesByUserIdAndDate(anyInt(),any()))
                .thenReturn(new DailyDietaryNotesDTO());
        when(bldstUtility.getBldstMap()).thenReturn(new HashMap<>());
        when(dailyDietaryExclusionsService.hasExclusion(anyInt(),any()))
                .thenReturn(true);
        when(usersService.findUsersById(anyInt()))
                .thenReturn(new UsersDTO());
        when(unsyncedService.hasUnsyncedRecord(anyInt(),any()))
                .thenReturn(false);
        DailyDietWrapper result = dailydietService.createDailyDiet(dailydietDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyDiet_Found() throws Exception {
        when(dailydietRepository.findById(anyInt())).thenReturn(Optional.of(dailydiet));
        when(dailydietRepository.save(any(DailyDiet.class))).thenReturn(dailydiet);
        when(dailydietRepository.findDailyDietByUserIdAndDate(
                anyInt(),any()))
                .thenReturn(Collections.emptyList());
        when(dailyDietaryNotesService
                .findDailyDietaryNotesByUserIdAndDate(anyInt(),any()))
                .thenReturn(new DailyDietaryNotesDTO());
        when(bldstUtility.getBldstMap()).thenReturn(new HashMap<>());
        when(dailyDietaryExclusionsService.hasExclusion(anyInt(),any()))
                .thenReturn(true);
        when(usersService.findUsersById(anyInt()))
                .thenReturn(new UsersDTO());
        when(unsyncedService.hasUnsyncedRecord(anyInt(),any()))
                .thenReturn(false);
        DailyDietWrapper result = dailydietService.updateDailyDiet(dailydietDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyDiet_NotFound() {
        when(dailydietRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietService.updateDailyDiet(dailydietDTO);
        });

        assertEquals("id = " + dailydietDTO.getDailyTotalId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteDailyDiet_Found() throws Exception {
        when(dailydietRepository.findById(anyInt())).thenReturn(Optional.of(dailydiet));
        doNothing().when(dailydietRepository).deleteById(anyInt());
        when(dailydietRepository.findDailyDietByUserIdAndDate(
                anyInt(),any()))
                .thenReturn(Collections.emptyList());
        when(dailyDietaryNotesService
                .findDailyDietaryNotesByUserIdAndDate(anyInt(),any()))
                .thenReturn(new DailyDietaryNotesDTO());
        when(bldstUtility.getBldstMap()).thenReturn(new HashMap<>());
        when(dailyDietaryExclusionsService.hasExclusion(anyInt(),any()))
                .thenReturn(true);
        when(usersService.findUsersById(anyInt()))
                .thenReturn(new UsersDTO());
        when(unsyncedService.hasUnsyncedRecord(anyInt(),any()))
                .thenReturn(false);
        DailyDietWrapper result = dailydietService.deleteDailyDiet(anyInt());

        assertNotNull(result);
    }

    @Test
    void testDeleteDailyDiet_NotFound() {
        when(dailydietRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietService.deleteDailyDiet(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static DailyDietDTO generateRandomDailyDiet() {
		DailyDietDTO record = new DailyDietDTO();
		record.setDailyTotalId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setIngrId(Randomizer.randomInt(1000));
		record.setIsRecipe(Randomizer.randomBoolean());
		record.setIsLocal(Randomizer.randomBoolean());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setTimeEaten(Randomizer.randomString(10));
		return record;
	}
    public static DailyDiet generateRandomDailyDietEntity() {
		DailyDiet record = new DailyDiet();
		record.setDailyTotalId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setIngrId(Randomizer.randomInt(1000));
		record.setIsRecipe(Randomizer.randomBoolean());
		record.setIsLocal(Randomizer.randomBoolean());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setTimeEaten(Randomizer.randomString(10));
		return record;
	}

}
