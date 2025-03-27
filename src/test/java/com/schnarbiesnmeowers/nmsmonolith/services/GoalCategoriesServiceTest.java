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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalCategoriesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalCategories;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalCategoriesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GoalCategoriesServiceTest {

    @Mock
    private GoalCategoriesRepository goalcategoriesRepository;

    @InjectMocks
    private GoalCategoriesService goalcategoriesService;

    private GoalCategories goalcategories;
    private GoalCategoriesDTO goalcategoriesDTO;

    @BeforeEach
    void setUp() {
        goalcategories = generateRandomGoalCategoriesEntity();
        goalcategoriesDTO = generateRandomGoalCategories();
    }

    @Test
    void testGetAllGoalCategories() throws Exception {
        when(goalcategoriesRepository.findAll()).thenReturn(Collections.singletonList(goalcategories));

        List<GoalCategoriesDTO> result = goalcategoriesService.getAllGoalCategories();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGoalCategoriesById_Found() throws Exception {
        when(goalcategoriesRepository.findById(anyInt())).thenReturn(Optional.of(goalcategories));

        GoalCategoriesDTO result = goalcategoriesService.findGoalCategoriesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGoalCategoriesById_NotFound() {
        when(goalcategoriesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalcategoriesService.findGoalCategoriesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGoalCategories() {
        when(goalcategoriesRepository.save(any(GoalCategories.class))).thenReturn(goalcategories);

        GoalCategoriesDTO result = goalcategoriesService.createGoalCategories(goalcategoriesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoalCategories_Found() throws Exception {
        when(goalcategoriesRepository.findById(anyInt())).thenReturn(Optional.of(goalcategories));
        when(goalcategoriesRepository.save(any(GoalCategories.class))).thenReturn(goalcategories);

        GoalCategoriesDTO result = goalcategoriesService.updateGoalCategories(goalcategoriesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoalCategories_NotFound() {
        when(goalcategoriesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalcategoriesService.updateGoalCategories(goalcategoriesDTO);
        });

        assertEquals("id = " + goalcategoriesDTO.getGcId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteGoalCategories_Found() throws Exception {
        when(goalcategoriesRepository.findById(anyInt())).thenReturn(Optional.of(goalcategories));
        doNothing().when(goalcategoriesRepository).deleteById(anyInt());

        String result = goalcategoriesService.deleteGoalCategories(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGoalCategories_NotFound() {
        when(goalcategoriesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalcategoriesService.deleteGoalCategories(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GoalCategoriesDTO generateRandomGoalCategories() {
		GoalCategoriesDTO record = new GoalCategoriesDTO();
		record.setGcId(2);
		record.setGoalTypeId(Randomizer.randomInt(1000));
		record.setGcDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static GoalCategories generateRandomGoalCategoriesEntity() {
		GoalCategories record = new GoalCategories();
		record.setGcId(2);
		record.setGoalTypeId(Randomizer.randomInt(1000));
		record.setGcDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
