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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalTypes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GoalTypesServiceTest {

    @Mock
    private GoalTypesRepository goaltypesRepository;

    @InjectMocks
    private GoalTypesService goaltypesService;

    private GoalTypes goaltypes;
    private GoalTypesDTO goaltypesDTO;

    @BeforeEach
    void setUp() {
        goaltypes = generateRandomGoalTypesEntity();
        goaltypesDTO = generateRandomGoalTypes();
    }

    @Test
    void testGetAllGoalTypes() throws Exception {
        when(goaltypesRepository.findAll()).thenReturn(Collections.singletonList(goaltypes));

        List<GoalTypesDTO> result = goaltypesService.getAllGoalTypes();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGoalTypesById_Found() throws Exception {
        when(goaltypesRepository.findById(anyInt())).thenReturn(Optional.of(goaltypes));

        GoalTypesDTO result = goaltypesService.findGoalTypesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGoalTypesById_NotFound() {
        when(goaltypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goaltypesService.findGoalTypesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGoalTypes() {
        when(goaltypesRepository.save(any(GoalTypes.class))).thenReturn(goaltypes);

        GoalTypesDTO result = goaltypesService.createGoalTypes(goaltypesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoalTypes_Found() throws Exception {
        when(goaltypesRepository.findById(anyInt())).thenReturn(Optional.of(goaltypes));
        when(goaltypesRepository.save(any(GoalTypes.class))).thenReturn(goaltypes);

        GoalTypesDTO result = goaltypesService.updateGoalTypes(goaltypesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoalTypes_NotFound() {
        when(goaltypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goaltypesService.updateGoalTypes(goaltypesDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteGoalTypes_Found() throws Exception {
        when(goaltypesRepository.findById(anyInt())).thenReturn(Optional.of(goaltypes));
        doNothing().when(goaltypesRepository).deleteById(anyInt());

        String result = goaltypesService.deleteGoalTypes(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGoalTypes_NotFound() {
        when(goaltypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goaltypesService.deleteGoalTypes(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GoalTypesDTO generateRandomGoalTypes() {
		GoalTypesDTO record = new GoalTypesDTO();
		record.setGoalTypeId(2);
		record.setGoalTypeCde(Randomizer.randomString(3));
		record.setGoalTypeDesc(Randomizer.randomString(20));
		return record;
	}
    public static GoalTypes generateRandomGoalTypesEntity() {
		GoalTypes record = new GoalTypes();
		record.setGoalTypeId(2);
		record.setGoalTypeCde(Randomizer.randomString(3));
		record.setGoalTypeDesc(Randomizer.randomString(20));
		return record;
	}

}
