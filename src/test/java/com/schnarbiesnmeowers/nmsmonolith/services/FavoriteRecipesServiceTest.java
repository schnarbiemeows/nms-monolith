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
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.FavoriteRecipesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteRecipes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteRecipesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class FavoriteRecipesServiceTest {

    @Mock
    private FavoriteRecipesRepository favoriterecipesRepository;

    @InjectMocks
    private FavoriteRecipesService favoriterecipesService;

    private FavoriteRecipes favoriterecipes;
    private FavoriteRecipesDTO favoriterecipesDTO;

    @BeforeEach
    void setUp() {
        favoriterecipes = generateRandomFavoriteRecipesEntity();
        favoriterecipesDTO = generateRandomFavoriteRecipes();
    }

    @Test
    void testGetAllFavoriteRecipes() throws Exception {
        when(favoriterecipesRepository.findAll()).thenReturn(Collections.singletonList(favoriterecipes));

        List<FavoriteRecipesDTO> result = favoriterecipesService.getAllFavoriteRecipes();

        assertEquals(1, result.size());
    }

    @Test
    void testFindFavoriteRecipesById_Found() throws Exception {
        when(favoriterecipesRepository.findById(anyInt())).thenReturn(Optional.of(favoriterecipes));

        FavoriteRecipesDTO result = favoriterecipesService.findFavoriteRecipesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindFavoriteRecipesById_NotFound() {
        when(favoriterecipesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoriterecipesService.findFavoriteRecipesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateFavoriteRecipes() {
        when(favoriterecipesRepository.save(any(FavoriteRecipes.class))).thenReturn(favoriterecipes);

        FavoriteRecipesDTO result = favoriterecipesService.createFavoriteRecipes(favoriterecipesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateFavoriteRecipes_Found() throws Exception {
        when(favoriterecipesRepository.findById(anyInt())).thenReturn(Optional.of(favoriterecipes));
        when(favoriterecipesRepository.save(any(FavoriteRecipes.class))).thenReturn(favoriterecipes);

        FavoriteRecipesDTO result = favoriterecipesService.updateFavoriteRecipes(favoriterecipesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateFavoriteRecipes_NotFound() {
        when(favoriterecipesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoriterecipesService.updateFavoriteRecipes(favoriterecipesDTO);
        });

        assertEquals("id = " + favoriterecipesDTO.getFavoriteRecipeId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteFavoriteRecipes_Found() throws Exception {
        when(favoriterecipesRepository.findById(anyInt())).thenReturn(Optional.of(favoriterecipes));
        doNothing().when(favoriterecipesRepository).deleteById(anyInt());

        String result = favoriterecipesService.deleteFavoriteRecipes(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteFavoriteRecipes_NotFound() {
        when(favoriterecipesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoriterecipesService.deleteFavoriteRecipes(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static FavoriteRecipesDTO generateRandomFavoriteRecipes() {
		FavoriteRecipesDTO record = new FavoriteRecipesDTO();
		record.setFavoriteRecipeId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
    public static FavoriteRecipes generateRandomFavoriteRecipesEntity() {
		FavoriteRecipes record = new FavoriteRecipes();
		record.setFavoriteRecipeId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setIsLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}

}
