package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeIngredients;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeIngredientsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RecipeIngredientsServiceTest {

    @Mock
    private RecipeIngredientsRepository recipeingredientsRepository;

    @InjectMocks
    private RecipeIngredientsService recipeingredientsService;

    private RecipeIngredients recipeingredients;
    private RecipeIngredientsDTO recipeingredientsDTO;

    @BeforeEach
    void setUp() {
        recipeingredients = generateRandomRecipeIngredientsEntity();
        recipeingredientsDTO = generateRandomRecipeIngredients();
    }

    @Test
    void testGetAllRecipeIngredients() throws Exception {
        when(recipeingredientsRepository.findAll()).thenReturn(Collections.singletonList(recipeingredients));

        List<RecipeIngredientsDTO> result = recipeingredientsService.getAllRecipeIngredients();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRecipeIngredientsById_Found() throws Exception {
        when(recipeingredientsRepository.findById(anyInt())).thenReturn(Optional.of(recipeingredients));

        RecipeIngredientsDTO result = recipeingredientsService.findRecipeIngredientsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRecipeIngredientsById_NotFound() {
        when(recipeingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipeingredientsService.findRecipeIngredientsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRecipeIngredients() {
        when(recipeingredientsRepository.save(any(RecipeIngredients.class))).thenReturn(recipeingredients);

        RecipeIngredientsDTO result = recipeingredientsService.createRecipeIngredients(recipeingredientsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeIngredients_Found() throws Exception {
        when(recipeingredientsRepository.findById(anyInt())).thenReturn(Optional.of(recipeingredients));
        when(recipeingredientsRepository.save(any(RecipeIngredients.class))).thenReturn(recipeingredients);

        RecipeIngredientsDTO result = recipeingredientsService.updateRecipeIngredients(recipeingredientsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeIngredients_NotFound() {
        when(recipeingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipeingredientsService.updateRecipeIngredients(recipeingredientsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteRecipeIngredients_Found() throws Exception {
        when(recipeingredientsRepository.findById(anyInt())).thenReturn(Optional.of(recipeingredients));
        doNothing().when(recipeingredientsRepository).deleteById(anyInt());

        String result = recipeingredientsService.deleteRecipeIngredients(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRecipeIngredients_NotFound() {
        when(recipeingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipeingredientsService.deleteRecipeIngredients(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RecipeIngredientsDTO generateRandomRecipeIngredients() {
		RecipeIngredientsDTO record = new RecipeIngredientsDTO();
		record.setRecipeIngrId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setRecOrIngrId(Randomizer.randomInt(1000));
		record.setRecipeFlg(Randomizer.randomString(2));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static RecipeIngredients generateRandomRecipeIngredientsEntity() {
		RecipeIngredients record = new RecipeIngredients();
		record.setRecipeIngrId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setRecOrIngrId(Randomizer.randomInt(1000));
		record.setRecipeFlg(Randomizer.randomString(2));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
