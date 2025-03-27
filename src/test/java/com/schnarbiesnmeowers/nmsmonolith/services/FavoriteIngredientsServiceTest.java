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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.FavoriteIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteIngredients;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteIngredientsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class FavoriteIngredientsServiceTest {

    @Mock
    private FavoriteIngredientsRepository favoriteingredientsRepository;

    @InjectMocks
    private FavoriteIngredientsService favoriteingredientsService;

    private FavoriteIngredients favoriteingredients;
    private FavoriteIngredientsDTO favoriteingredientsDTO;

    @BeforeEach
    void setUp() {
        favoriteingredients = generateRandomFavoriteIngredientsEntity();
        favoriteingredientsDTO = generateRandomFavoriteIngredients();
    }

    @Test
    void testGetAllFavoriteIngredients() throws Exception {
        when(favoriteingredientsRepository.findAll()).thenReturn(Collections.singletonList(favoriteingredients));

        List<FavoriteIngredientsDTO> result = favoriteingredientsService.getAllFavoriteIngredients();

        assertEquals(1, result.size());
    }

    @Test
    void testFindFavoriteIngredientsById_Found() throws Exception {
        when(favoriteingredientsRepository.findById(anyInt())).thenReturn(Optional.of(favoriteingredients));

        FavoriteIngredientsDTO result = favoriteingredientsService.findFavoriteIngredientsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindFavoriteIngredientsById_NotFound() {
        when(favoriteingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoriteingredientsService.findFavoriteIngredientsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateFavoriteIngredients() {
        when(favoriteingredientsRepository.save(any(FavoriteIngredients.class))).thenReturn(favoriteingredients);

        FavoriteIngredientsDTO result = favoriteingredientsService.createFavoriteIngredients(favoriteingredientsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateFavoriteIngredients_Found() throws Exception {
        when(favoriteingredientsRepository.findById(anyInt())).thenReturn(Optional.of(favoriteingredients));
        when(favoriteingredientsRepository.save(any(FavoriteIngredients.class))).thenReturn(favoriteingredients);

        FavoriteIngredientsDTO result = favoriteingredientsService.updateFavoriteIngredients(favoriteingredientsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateFavoriteIngredients_NotFound() {
        when(favoriteingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoriteingredientsService.updateFavoriteIngredients(favoriteingredientsDTO);
        });

        assertEquals("id = " + favoriteingredientsDTO.getFavoriteIngredientId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteFavoriteIngredients_Found() throws Exception {
        when(favoriteingredientsRepository.findById(anyInt())).thenReturn(Optional.of(favoriteingredients));
        doNothing().when(favoriteingredientsRepository).deleteById(anyInt());

        String result = favoriteingredientsService.deleteFavoriteIngredients(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteFavoriteIngredients_NotFound() {
        when(favoriteingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoriteingredientsService.deleteFavoriteIngredients(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static FavoriteIngredientsDTO generateRandomFavoriteIngredients() {
		FavoriteIngredientsDTO record = new FavoriteIngredientsDTO();
		record.setFavoriteIngredientId(2);
		record.setIngrId(Randomizer.randomInt(1000));
		record.setLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
    public static FavoriteIngredients generateRandomFavoriteIngredientsEntity() {
		FavoriteIngredients record = new FavoriteIngredients();
		record.setFavoriteIngredientId(2);
		record.setIngrId(Randomizer.randomInt(1000));
		record.setIsLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}

}
