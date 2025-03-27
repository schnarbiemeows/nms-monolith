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
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DietaryTemplatesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.DietaryTemplates;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DietaryTemplatesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class DietaryTemplatesServiceTest {

    @Mock
    private DietaryTemplatesRepository dietarytemplatesRepository;

    @InjectMocks
    private DietaryTemplatesService dietarytemplatesService;

    private DietaryTemplates dietarytemplates;
    private DietaryTemplatesDTO dietarytemplatesDTO;

    @BeforeEach
    void setUp() {
        dietarytemplates = generateRandomDietaryTemplatesEntity();
        dietarytemplatesDTO = generateRandomDietaryTemplates();
    }

    @Test
    void testGetAllDietaryTemplates() throws Exception {
        when(dietarytemplatesRepository.findAll()).thenReturn(Collections.singletonList(dietarytemplates));

        List<DietaryTemplatesDTO> result = dietarytemplatesService.getAllDietaryTemplates();

        assertEquals(1, result.size());
    }

    @Test
    void testFindDietaryTemplatesById_Found() throws Exception {
        when(dietarytemplatesRepository.findById(anyInt())).thenReturn(Optional.of(dietarytemplates));

        DietaryTemplatesDTO result = dietarytemplatesService.findDietaryTemplatesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindDietaryTemplatesById_NotFound() {
        when(dietarytemplatesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dietarytemplatesService.findDietaryTemplatesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateDietaryTemplates() {
        when(dietarytemplatesRepository.save(any(DietaryTemplates.class))).thenReturn(dietarytemplates);

        DietaryTemplatesDTO result = dietarytemplatesService.createDietaryTemplates(dietarytemplatesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDietaryTemplates_Found() throws Exception {
        when(dietarytemplatesRepository.findById(anyInt())).thenReturn(Optional.of(dietarytemplates));
        when(dietarytemplatesRepository.save(any(DietaryTemplates.class))).thenReturn(dietarytemplates);

        DietaryTemplatesDTO result = dietarytemplatesService.updateDietaryTemplates(dietarytemplatesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDietaryTemplates_NotFound() {
        when(dietarytemplatesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dietarytemplatesService.updateDietaryTemplates(dietarytemplatesDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteDietaryTemplates_Found() throws Exception {
        when(dietarytemplatesRepository.findById(anyInt())).thenReturn(Optional.of(dietarytemplates));
        doNothing().when(dietarytemplatesRepository).deleteById(anyInt());

        String result = dietarytemplatesService.deleteDietaryTemplates(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteDietaryTemplates_NotFound() {
        when(dietarytemplatesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dietarytemplatesService.deleteDietaryTemplates(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static DietaryTemplatesDTO generateRandomDietaryTemplates() {
		DietaryTemplatesDTO record = new DietaryTemplatesDTO();
		record.setDietaryTemplateId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setTemplateName(Randomizer.randomString(20));
		return record;
	}
    public static DietaryTemplates generateRandomDietaryTemplatesEntity() {
		DietaryTemplates record = new DietaryTemplates();
		record.setDietaryTemplateId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setTemplateName(Randomizer.randomString(20));
		return record;
	}
}
