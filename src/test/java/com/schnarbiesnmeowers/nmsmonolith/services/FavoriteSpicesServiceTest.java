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
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.FavoriteSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteSpices;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteSpicesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class FavoriteSpicesServiceTest {

    @Mock
    private FavoriteSpicesRepository favoritespicesRepository;

    @InjectMocks
    private FavoriteSpicesService favoritespicesService;

    private FavoriteSpices favoritespices;
    private FavoriteSpicesDTO favoritespicesDTO;

    @BeforeEach
    void setUp() {
        favoritespices = generateRandomFavoriteSpicesEntity();
        favoritespicesDTO = generateRandomFavoriteSpices();
    }

    @Test
    void testGetAllFavoriteSpices() throws Exception {
        when(favoritespicesRepository.findAll()).thenReturn(Collections.singletonList(favoritespices));

        List<FavoriteSpicesDTO> result = favoritespicesService.getAllFavoriteSpices();

        assertEquals(1, result.size());
    }

    @Test
    void testFindFavoriteSpicesById_Found() throws Exception {
        when(favoritespicesRepository.findById(anyInt())).thenReturn(Optional.of(favoritespices));

        FavoriteSpicesDTO result = favoritespicesService.findFavoriteSpicesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindFavoriteSpicesById_NotFound() {
        when(favoritespicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoritespicesService.findFavoriteSpicesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateFavoriteSpices() {
        when(favoritespicesRepository.save(any(FavoriteSpices.class))).thenReturn(favoritespices);

        FavoriteSpicesDTO result = favoritespicesService.createFavoriteSpices(favoritespicesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateFavoriteSpices_Found() throws Exception {
        when(favoritespicesRepository.findById(anyInt())).thenReturn(Optional.of(favoritespices));
        when(favoritespicesRepository.save(any(FavoriteSpices.class))).thenReturn(favoritespices);

        FavoriteSpicesDTO result = favoritespicesService.updateFavoriteSpices(favoritespicesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateFavoriteSpices_NotFound() {
        when(favoritespicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoritespicesService.updateFavoriteSpices(favoritespicesDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteFavoriteSpices_Found() throws Exception {
        when(favoritespicesRepository.findById(anyInt())).thenReturn(Optional.of(favoritespices));
        doNothing().when(favoritespicesRepository).deleteById(anyInt());

        String result = favoritespicesService.deleteFavoriteSpices(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteFavoriteSpices_NotFound() {
        when(favoritespicesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoritespicesService.deleteFavoriteSpices(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static FavoriteSpicesDTO generateRandomFavoriteSpices() {
		FavoriteSpicesDTO record = new FavoriteSpicesDTO();
		record.setFavoriteSpiceId(2);
		record.setSpiceId(Randomizer.randomInt(1000));
		record.setIsLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
    public static FavoriteSpices generateRandomFavoriteSpicesEntity() {
		FavoriteSpices record = new FavoriteSpices();
		record.setFavoriteSpiceId(2);
		record.setSpiceId(Randomizer.randomInt(1000));
		record.setIsLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}

}
