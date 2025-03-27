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
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RecipeTypeServiceTest {

    @Mock
    private RecipeTypeRepository recipetypeRepository;

    @InjectMocks
    private RecipeTypeService recipetypeService;

    private RecipeType recipetype;
    private RecipeTypeDTO recipetypeDTO;

    @BeforeEach
    void setUp() {
        recipetype = generateRandomRecipeTypeEntity();
        recipetypeDTO = generateRandomRecipeType();
    }

    @Test
    void testGetAllRecipeType() throws Exception {
        when(recipetypeRepository.findAll()).thenReturn(Collections.singletonList(recipetype));

        List<RecipeTypeDTO> result = recipetypeService.getAllRecipeType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRecipeTypeById_Found() throws Exception {
        when(recipetypeRepository.findById(anyInt())).thenReturn(Optional.of(recipetype));

        RecipeTypeDTO result = recipetypeService.findRecipeTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRecipeTypeById_NotFound() {
        when(recipetypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipetypeService.findRecipeTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRecipeType() {
        when(recipetypeRepository.save(any(RecipeType.class))).thenReturn(recipetype);

        RecipeTypeDTO result = recipetypeService.createRecipeType(recipetypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeType_Found() throws Exception {
        when(recipetypeRepository.findById(anyInt())).thenReturn(Optional.of(recipetype));
        when(recipetypeRepository.save(any(RecipeType.class))).thenReturn(recipetype);

        RecipeTypeDTO result = recipetypeService.updateRecipeType(recipetypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipeType_NotFound() {
        when(recipetypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipetypeService.updateRecipeType(recipetypeDTO);
        });

        assertEquals("id = " + recipetypeDTO.getRecipeTypeId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteRecipeType_Found() throws Exception {
        when(recipetypeRepository.findById(anyInt())).thenReturn(Optional.of(recipetype));
        doNothing().when(recipetypeRepository).deleteById(anyInt());

        String result = recipetypeService.deleteRecipeType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRecipeType_NotFound() {
        when(recipetypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipetypeService.deleteRecipeType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RecipeTypeDTO generateRandomRecipeType() {
		RecipeTypeDTO record = new RecipeTypeDTO();
		record.setRecipeTypeId(2);
		record.setRecipeTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static RecipeType generateRandomRecipeTypeEntity() {
		RecipeType record = new RecipeType();
		record.setRecipeTypeId(2);
		record.setRecipeTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
