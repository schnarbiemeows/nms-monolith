package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Spices;
import com.schnarbiesnmeowers.nmsmonolith.repositories.SpicesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class SpicesServiceTest {

    @Mock
    private SpicesRepository spicesRepository;

    @Mock
    FavoriteSpicesService favoriteSpicesService;

    @Mock
    private RecipeSpicesService recipeSpicesService;

    @Mock
    private LocalRecipeSpicesService localRecipeSpicesService;

    @InjectMocks
    private SpicesService spicesService;

    private Spices spices;
    private SpicesDTO spicesDTO;

    @BeforeEach
    void setUp() {
        spices = generateRandomSpicesEntity();
        spicesDTO = generateRandomSpices();
    }

    @Test
    void testGetAllSpices() throws Exception {
        when(spicesRepository.findAllActiveGlobalSpices()).thenReturn(Collections.singletonList(spices));

        List<SpicesDTO> result = spicesService.getAllSpices();

        assertEquals(1, result.size());
    }

    @Test
    void testFindSpicesById_Found() throws Exception {
        when(spicesRepository.findById(anyInt())).thenReturn(Optional.of(spices));

        SpicesDTO result = spicesService.findSpicesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindSpicesById_NotFound() {
        when(spicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            spicesService.findSpicesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateSpices() {
        when(spicesRepository.save(any(Spices.class))).thenReturn(spices);

        SpicesDTO result = spicesService.createSpices(spicesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateSpices_Found() throws Exception {
        when(spicesRepository.findById(anyInt())).thenReturn(Optional.of(spices));
        when(spicesRepository.save(any(Spices.class))).thenReturn(spices);

        SpicesDTO result = spicesService.updateSpices(spicesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateSpices_NotFound() {
        when(spicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            spicesService.updateSpices(spicesDTO);
        });

        assertEquals("id = " + spicesDTO.getSpiceId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteSpices_Found() throws Exception {
        when(spicesRepository.findById(anyInt())).thenReturn(Optional.of(spices));
        when(favoriteSpicesService.checkForFavoriteDependencies(anyInt(),isNull(),eq(false)))
                .thenReturn(false);
        when(recipeSpicesService.checkForGlobalRecipesThatAreDependentUponThisGlobalSpice(anyInt()))
                .thenReturn(false);
        when(spicesRepository.save(any())).thenReturn(spices);

        String result = spicesService.deleteSpices(2);

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteSpices_NotFound() {
        when(spicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            spicesService.deleteSpices(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static SpicesDTO generateRandomSpices() {
		SpicesDTO record = new SpicesDTO();
		record.setSpiceId(2);
		record.setSpiceName(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		record.setImageLoc(Randomizer.randomInt(1000));
		return record;
	}
    public static Spices generateRandomSpicesEntity() {
		Spices record = new Spices();
		record.setSpiceId(2);
		record.setSpiceName(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		record.setImageLoc(Randomizer.randomInt(1000));
		return record;
	}
}
