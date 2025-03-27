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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Goals;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GoalsServiceTest {

    @Mock
    private GoalsRepository goalsRepository;

    @InjectMocks
    private GoalsService goalsService;

    private Goals goals;
    private GoalsDTO goalsDTO;

    @BeforeEach
    void setUp() {
        goals = generateRandomGoalsEntity();
        goalsDTO = generateRandomGoals();
    }

    @Test
    void testGetAllGoals() throws Exception {
        when(goalsRepository.findAll()).thenReturn(Collections.singletonList(goals));

        List<GoalsDTO> result = goalsService.getAllGoals();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGoalsById_Found() throws Exception {
        when(goalsRepository.findById(anyInt())).thenReturn(Optional.of(goals));

        GoalsDTO result = goalsService.findGoalsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGoalsById_NotFound() {
        when(goalsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalsService.findGoalsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGoals() {
        when(goalsRepository.save(any(Goals.class))).thenReturn(goals);

        GoalsDTO result = goalsService.createGoals(goalsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoals_Found() throws Exception {
        when(goalsRepository.findById(anyInt())).thenReturn(Optional.of(goals));
        when(goalsRepository.save(any(Goals.class))).thenReturn(goals);

        GoalsDTO result = goalsService.updateGoals(goalsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoals_NotFound() {
        when(goalsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalsService.updateGoals(goalsDTO);
        });

        assertEquals("id = " + goalsDTO.getGoalId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteGoals_Found() throws Exception {
        when(goalsRepository.findById(anyInt())).thenReturn(Optional.of(goals));
        doNothing().when(goalsRepository).deleteById(anyInt());

        String result = goalsService.deleteGoals(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGoals_NotFound() {
        when(goalsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalsService.deleteGoals(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GoalsDTO generateRandomGoals() {
		GoalsDTO record = new GoalsDTO();
		record.setGoalId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setGoalName(Randomizer.randomString(20));
		record.setGcId(Randomizer.randomInt(1000));
		record.setComparator(Randomizer.randomString(3));
		record.setCompFld(Randomizer.randomString(20));
		record.setNumTimes(Randomizer.randomInt(1000));
		record.setTimesMet(Randomizer.randomInt(1000));
		record.setConseq(Randomizer.randomString(2));
		record.setRenew(Randomizer.randomString(2));
		record.setAchieved(Randomizer.randomString(2));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Goals generateRandomGoalsEntity() {
		Goals record = new Goals();
		record.setGoalId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setGoalName(Randomizer.randomString(20));
		record.setGcId(Randomizer.randomInt(1000));
		record.setComparator(Randomizer.randomString(3));
		record.setCompFld(Randomizer.randomString(20));
		record.setNumTimes(Randomizer.randomInt(1000));
		record.setTimesMet(Randomizer.randomInt(1000));
		record.setConseq(Randomizer.randomString(2));
		record.setRenew(Randomizer.randomString(2));
		record.setAchieved(Randomizer.randomString(2));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
