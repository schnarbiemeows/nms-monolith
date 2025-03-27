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
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.RecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeSpices;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeSpicesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RecipeSpicesServiceTest {

    @Mock
    private RecipeSpicesRepository recipespicesRepository;

    @InjectMocks
    private RecipeSpicesService recipespicesService;

    private RecipeSpices recipespices;
    private RecipeSpicesDTO recipespicesDTO;

    @BeforeEach
    void setUp() {
        recipespices = generateRandomRecipeSpicesEntity();
        recipespicesDTO = generateRandomRecipeSpices();
    }

    @Test
    void testGetAllRecipeSpices() throws Exception {
        when(recipespicesRepository.findAll()).thenReturn(Collections.singletonList(recipespices));

        List<RecipeSpicesDTO> result = recipespicesService.getAllRecipeSpices();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRecipeSpicesById_Found() throws Exception {
        when(recipespicesRepository.findById(anyInt())).thenReturn(Optional.of(recipespices));

        RecipeSpicesDTO result = recipespicesService.findRecipeSpicesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRecipeSpicesById_NotFound() {
        when(recipespicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipespicesService.findRecipeSpicesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRecipeSpices() {
        when(recipespicesRepository.save(any(RecipeSpices.class))).thenReturn(recipespices);

        RecipeSpicesDTO result = recipespicesService.createRecipeSpices(recipespicesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeSpices_Found() throws Exception {
        when(recipespicesRepository.findById(anyInt())).thenReturn(Optional.of(recipespices));
        when(recipespicesRepository.save(any(RecipeSpices.class))).thenReturn(recipespices);

        RecipeSpicesDTO result = recipespicesService.updateRecipeSpices(recipespicesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeSpices_NotFound() {
        when(recipespicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipespicesService.updateRecipeSpices(recipespicesDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteRecipeSpices_Found() throws Exception {
        when(recipespicesRepository.findById(anyInt())).thenReturn(Optional.of(recipespices));
        doNothing().when(recipespicesRepository).deleteById(anyInt());

        String result = recipespicesService.deleteRecipeSpices(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRecipeSpices_NotFound() {
        when(recipespicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipespicesService.deleteRecipeSpices(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RecipeSpicesDTO generateRandomRecipeSpices() {
		RecipeSpicesDTO record = new RecipeSpicesDTO();
		record.setRecipeSpiceId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setSpiceId(Randomizer.randomInt(1000));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static RecipeSpices generateRandomRecipeSpicesEntity() {
		RecipeSpices record = new RecipeSpices();
		record.setRecipeSpiceId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setSpiceId(Randomizer.randomInt(1000));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
