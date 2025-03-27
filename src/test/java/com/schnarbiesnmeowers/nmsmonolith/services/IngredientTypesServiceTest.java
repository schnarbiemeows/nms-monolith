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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.IngredientTypes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.IngredientTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class IngredientTypesServiceTest {

    @Mock
    private IngredientTypesRepository ingredienttypesRepository;

    @InjectMocks
    private IngredientTypesService ingredienttypesService;

    private IngredientTypes ingredienttypes;
    private IngredientTypesDTO ingredienttypesDTO;

    @BeforeEach
    void setUp() {
        ingredienttypes = generateRandomIngredientTypesEntity();
        ingredienttypesDTO = generateRandomIngredientTypes();
    }

    @Test
    void testGetAllIngredientTypes() throws Exception {
        when(ingredienttypesRepository.findActiveIngredientTypes()).thenReturn(Collections.singletonList(ingredienttypes));

        List<IngredientTypesDTO> result = ingredienttypesService.getAllIngredientTypes();

        assertEquals(1, result.size());
    }

    @Test
    void testFindIngredientTypesById_Found() throws Exception {
        when(ingredienttypesRepository.findById(anyInt())).thenReturn(Optional.of(ingredienttypes));

        IngredientTypesDTO result = ingredienttypesService.findIngredientTypesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindIngredientTypesById_NotFound() {
        when(ingredienttypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            ingredienttypesService.findIngredientTypesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateIngredientTypes() {
        when(ingredienttypesRepository.save(any(IngredientTypes.class))).thenReturn(ingredienttypes);

        IngredientTypesDTO result = ingredienttypesService.createIngredientTypes(ingredienttypesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateIngredientTypes_Found() throws Exception {
        when(ingredienttypesRepository.findById(anyInt())).thenReturn(Optional.of(ingredienttypes));
        when(ingredienttypesRepository.save(any(IngredientTypes.class))).thenReturn(ingredienttypes);

        IngredientTypesDTO result = ingredienttypesService.updateIngredientTypes(ingredienttypesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateIngredientTypes_NotFound() {
        when(ingredienttypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            ingredienttypesService.updateIngredientTypes(ingredienttypesDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteIngredientTypes_Found() throws Exception {
        when(ingredienttypesRepository.findById(anyInt())).thenReturn(Optional.of(ingredienttypes));
        doNothing().when(ingredienttypesRepository).deleteById(anyInt());

        String result = ingredienttypesService.deleteIngredientTypes(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteIngredientTypes_NotFound() {
        when(ingredienttypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            ingredienttypesService.deleteIngredientTypes(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static IngredientTypesDTO generateRandomIngredientTypes() {
		IngredientTypesDTO record = new IngredientTypesDTO();
		record.setIngrTypeId(2);
		record.setPrntIngrType(Randomizer.randomInt(1000));
		record.setIngrTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static IngredientTypes generateRandomIngredientTypesEntity() {
		IngredientTypes record = new IngredientTypes();
		record.setIngrTypeId(2);
		record.setPrntIngrType(Randomizer.randomInt(1000));
		record.setIngrTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
