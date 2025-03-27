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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeSteps;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeStepsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RecipeStepsServiceTest {

    @Mock
    private RecipeStepsRepository recipestepsRepository;

    @InjectMocks
    private RecipeStepsService recipestepsService;

    private RecipeSteps recipesteps;
    private RecipeStepsDTO recipestepsDTO;

    @BeforeEach
    void setUp() {
        recipesteps = generateRandomRecipeStepsEntity();
        recipestepsDTO = generateRandomRecipeSteps();
    }

    @Test
    void testGetAllRecipeSteps() throws Exception {
        when(recipestepsRepository.findAll()).thenReturn(Collections.singletonList(recipesteps));

        List<RecipeStepsDTO> result = recipestepsService.getAllRecipeSteps();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRecipeStepsById_Found() throws Exception {
        when(recipestepsRepository.findById(anyInt())).thenReturn(Optional.of(recipesteps));

        RecipeStepsDTO result = recipestepsService.findRecipeStepsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRecipeStepsById_NotFound() {
        when(recipestepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipestepsService.findRecipeStepsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRecipeSteps() {
        when(recipestepsRepository.save(any(RecipeSteps.class))).thenReturn(recipesteps);

        RecipeStepsDTO result = recipestepsService.createRecipeSteps(recipestepsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeSteps_Found() throws Exception {
        when(recipestepsRepository.findById(anyInt())).thenReturn(Optional.of(recipesteps));
        when(recipestepsRepository.save(any(RecipeSteps.class))).thenReturn(recipesteps);

        RecipeStepsDTO result = recipestepsService.updateRecipeSteps(recipestepsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeSteps_NotFound() {
        when(recipestepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipestepsService.updateRecipeSteps(recipestepsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteRecipeSteps_Found() throws Exception {
        when(recipestepsRepository.findById(anyInt())).thenReturn(Optional.of(recipesteps));
        doNothing().when(recipestepsRepository).deleteById(anyInt());

        String result = recipestepsService.deleteRecipeSteps(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRecipeSteps_NotFound() {
        when(recipestepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipestepsService.deleteRecipeSteps(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RecipeStepsDTO generateRandomRecipeSteps() {
		RecipeStepsDTO record = new RecipeStepsDTO();
		record.setRecipeStepId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setStepNum(Randomizer.randomInt(1000));
		record.setStepDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static RecipeSteps generateRandomRecipeStepsEntity() {
		RecipeSteps record = new RecipeSteps();
		record.setRecipeStepId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setStepNum(Randomizer.randomInt(1000));
		record.setStepDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
