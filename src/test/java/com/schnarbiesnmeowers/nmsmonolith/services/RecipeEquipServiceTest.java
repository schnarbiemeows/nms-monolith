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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeEquipDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeEquip;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeEquipRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RecipeEquipServiceTest {

    @Mock
    private RecipeEquipRepository recipeequipRepository;

    @InjectMocks
    private RecipeEquipService recipeequipService;

    private RecipeEquip recipeequip;
    private RecipeEquipDTO recipeequipDTO;

    @BeforeEach
    void setUp() {
        recipeequip = generateRandomRecipeEquipEntity();
        recipeequipDTO = generateRandomRecipeEquip();
    }

    @Test
    void testGetAllRecipeEquip() throws Exception {
        when(recipeequipRepository.findAll()).thenReturn(Collections.singletonList(recipeequip));

        List<RecipeEquipDTO> result = recipeequipService.getAllRecipeEquip();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRecipeEquipById_Found() throws Exception {
        when(recipeequipRepository.findById(anyInt())).thenReturn(Optional.of(recipeequip));

        RecipeEquipDTO result = recipeequipService.findRecipeEquipById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRecipeEquipById_NotFound() {
        when(recipeequipRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipeequipService.findRecipeEquipById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRecipeEquip() {
        when(recipeequipRepository.save(any(RecipeEquip.class))).thenReturn(recipeequip);

        RecipeEquipDTO result = recipeequipService.createRecipeEquip(recipeequipDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeEquip_Found() throws Exception {
        when(recipeequipRepository.findById(anyInt())).thenReturn(Optional.of(recipeequip));
        when(recipeequipRepository.save(any(RecipeEquip.class))).thenReturn(recipeequip);

        RecipeEquipDTO result = recipeequipService.updateRecipeEquip(recipeequipDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeEquip_NotFound() {
        when(recipeequipRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipeequipService.updateRecipeEquip(recipeequipDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteRecipeEquip_Found() throws Exception {
        when(recipeequipRepository.findById(anyInt())).thenReturn(Optional.of(recipeequip));
        doNothing().when(recipeequipRepository).deleteById(anyInt());

        String result = recipeequipService.deleteRecipeEquip(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRecipeEquip_NotFound() {
        when(recipeequipRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipeequipService.deleteRecipeEquip(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RecipeEquipDTO generateRandomRecipeEquip() {
		RecipeEquipDTO record = new RecipeEquipDTO();
		record.setRecipeEquipId(2);
		record.setRecEqTypeId(Randomizer.randomInt(1000));
		record.setEquipDesc(Randomizer.randomString(20));
		record.setEquipLongDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static RecipeEquip generateRandomRecipeEquipEntity() {
		RecipeEquip record = new RecipeEquip();
		record.setRecipeEquipId(2);
		record.setRecEqTypeId(Randomizer.randomInt(1000));
		record.setEquipDesc(Randomizer.randomString(20));
		record.setEquipLongDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
