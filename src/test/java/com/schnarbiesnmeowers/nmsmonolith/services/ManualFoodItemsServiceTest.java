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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ManualFoodItemsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ManualFoodItems;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ManualFoodItemsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class ManualFoodItemsServiceTest {

    @Mock
    private ManualFoodItemsRepository manualfooditemsRepository;

    @InjectMocks
    private ManualFoodItemsService manualfooditemsService;

    private ManualFoodItems manualfooditems;
    private ManualFoodItemsDTO manualfooditemsDTO;

    @BeforeEach
    void setUp() {
        manualfooditems = generateRandomManualFoodItemsEntity();
        manualfooditemsDTO = generateRandomManualFoodItems();
    }

    @Test
    void testGetAllManualFoodItems() throws Exception {
        when(manualfooditemsRepository.findAll()).thenReturn(Collections.singletonList(manualfooditems));

        List<ManualFoodItemsDTO> result = manualfooditemsService.getAllManualFoodItems();

        assertEquals(1, result.size());
    }

    @Test
    void testFindManualFoodItemsById_Found() throws Exception {
        when(manualfooditemsRepository.findById(anyInt())).thenReturn(Optional.of(manualfooditems));

        ManualFoodItemsDTO result = manualfooditemsService.findManualFoodItemsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindManualFoodItemsById_NotFound() {
        when(manualfooditemsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            manualfooditemsService.findManualFoodItemsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateManualFoodItems() {
        when(manualfooditemsRepository.save(any(ManualFoodItems.class))).thenReturn(manualfooditems);

        ManualFoodItemsDTO result = manualfooditemsService.createManualFoodItems(manualfooditemsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateManualFoodItems_Found() throws Exception {
        when(manualfooditemsRepository.findById(anyInt())).thenReturn(Optional.of(manualfooditems));
        when(manualfooditemsRepository.save(any(ManualFoodItems.class))).thenReturn(manualfooditems);

        ManualFoodItemsDTO result = manualfooditemsService.updateManualFoodItems(manualfooditemsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateManualFoodItems_NotFound() {
        when(manualfooditemsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            manualfooditemsService.updateManualFoodItems(manualfooditemsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteManualFoodItems_Found() throws Exception {
        when(manualfooditemsRepository.findById(anyInt())).thenReturn(Optional.of(manualfooditems));
        doNothing().when(manualfooditemsRepository).deleteById(anyInt());

        String result = manualfooditemsService.deleteManualFoodItems(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteManualFoodItems_NotFound() {
        when(manualfooditemsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            manualfooditemsService.deleteManualFoodItems(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static ManualFoodItemsDTO generateRandomManualFoodItems() {
		ManualFoodItemsDTO record = new ManualFoodItemsDTO();
		record.setManualFoodItemId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setIngrId(Randomizer.randomInt(1000));
		record.setIsRecipe(Randomizer.randomBoolean());
		record.setIsLocal(Randomizer.randomBoolean());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		return record;
	}
    public static ManualFoodItems generateRandomManualFoodItemsEntity() {
		ManualFoodItems record = new ManualFoodItems();
		record.setManualFoodItemId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setIngrId(Randomizer.randomInt(1000));
		record.setIsRecipe(Randomizer.randomBoolean());
		record.setIsLocal(Randomizer.randomBoolean());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		return record;
	}
}
