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
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietaryNotes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietaryNotesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class DailyDietaryNotesServiceTest {

    @Mock
    private DailyDietaryNotesRepository dailydietarynotesRepository;

    @InjectMocks
    private DailyDietaryNotesService dailydietarynotesService;

    private DailyDietaryNotes dailydietarynotes;
    private DailyDietaryNotesDTO dailydietarynotesDTO;

    @BeforeEach
    void setUp() {
        dailydietarynotes = generateRandomDailyDietaryNotesEntity();
        dailydietarynotesDTO = generateRandomDailyDietaryNotes();
    }

    @Test
    void testGetAllDailyDietaryNotes() throws Exception {
        when(dailydietarynotesRepository.findAll()).thenReturn(Collections.singletonList(dailydietarynotes));

        List<DailyDietaryNotesDTO> result = dailydietarynotesService.getAllDailyDietaryNotes();

        assertEquals(1, result.size());
    }

    @Test
    void testFindDailyDietaryNotesById_Found() throws Exception {
        when(dailydietarynotesRepository.findById(anyInt())).thenReturn(Optional.of(dailydietarynotes));

        DailyDietaryNotesDTO result = dailydietarynotesService.findDailyDietaryNotesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindDailyDietaryNotesById_NotFound() {
        when(dailydietarynotesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietarynotesService.findDailyDietaryNotesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateDailyDietaryNotes() {
        when(dailydietarynotesRepository.save(any(DailyDietaryNotes.class))).thenReturn(dailydietarynotes);

        DailyDietaryNotesDTO result = dailydietarynotesService.createDailyDietaryNotes(dailydietarynotesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyDietaryNotes_Found() throws Exception {
        when(dailydietarynotesRepository.findById(anyInt())).thenReturn(Optional.of(dailydietarynotes));
        when(dailydietarynotesRepository.save(any(DailyDietaryNotes.class))).thenReturn(dailydietarynotes);

        DailyDietaryNotesDTO result = dailydietarynotesService.updateDailyDietaryNotes(dailydietarynotesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyDietaryNotes_NotFound() {
        when(dailydietarynotesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietarynotesService.updateDailyDietaryNotes(dailydietarynotesDTO);
        });

        assertEquals("id = " + dailydietarynotesDTO.getDdnId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteDailyDietaryNotes_Found() throws Exception {
        when(dailydietarynotesRepository.findById(anyInt())).thenReturn(Optional.of(dailydietarynotes));
        doNothing().when(dailydietarynotesRepository).deleteById(anyInt());

        String result = dailydietarynotesService.deleteDailyDietaryNotes(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteDailyDietaryNotes_NotFound() {
        when(dailydietarynotesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietarynotesService.deleteDailyDietaryNotes(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static DailyDietaryNotesDTO generateRandomDailyDietaryNotes() {
		DailyDietaryNotesDTO record = new DailyDietaryNotesDTO();
		record.setDdnId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setDailyNotes(Randomizer.randomString(20));
		return record;
	}
    public static DailyDietaryNotes generateRandomDailyDietaryNotesEntity() {
		DailyDietaryNotes record = new DailyDietaryNotes();
		record.setDdnId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setDailyNotes(Randomizer.randomString(20));
		return record;
	}

	/**
	 * get List<DailyDietaryNotesDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDietaryNotes>
	 * @throws Exception
	*/
	public List<DailyDietaryNotesDTO> findDailyDietaryNotesByUserId(int id) throws Exception {
		List<DailyDietaryNotesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
