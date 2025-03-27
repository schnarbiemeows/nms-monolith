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
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.FavoriteBrandsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteBrands;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteBrandsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class FavoriteBrandsServiceTest {

    @Mock
    private FavoriteBrandsRepository favoritebrandsRepository;


    @InjectMocks
    private FavoriteBrandsService favoritebrandsService;

    private FavoriteBrands favoritebrands;
    private FavoriteBrandsDTO favoritebrandsDTO;

    @BeforeEach
    void setUp() {
        favoritebrands = generateRandomFavoriteBrandsEntity();
        favoritebrandsDTO = generateRandomFavoriteBrands();
    }

    @Test
    void testGetAllFavoriteBrands() throws Exception {
        when(favoritebrandsRepository.findAll()).thenReturn(Collections.singletonList(favoritebrands));

        List<FavoriteBrandsDTO> result = favoritebrandsService.getAllFavoriteBrands();

        assertEquals(1, result.size());
    }

    @Test
    void testFindFavoriteBrandsById_Found() throws Exception {
        when(favoritebrandsRepository.findById(anyInt())).thenReturn(Optional.of(favoritebrands));

        FavoriteBrandsDTO result = favoritebrandsService.findFavoriteBrandsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindFavoriteBrandsById_NotFound() {
        when(favoritebrandsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoritebrandsService.findFavoriteBrandsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateFavoriteBrands() throws Exception {
        when(favoritebrandsRepository.save(any(FavoriteBrands.class))).thenReturn(favoritebrands);

        FavoriteBrandsDTO result = favoritebrandsService.createFavoriteBrands(favoritebrandsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateFavoriteBrands_Found() throws Exception {
        when(favoritebrandsRepository.findById(anyInt())).thenReturn(Optional.of(favoritebrands));
        when(favoritebrandsRepository.save(any(FavoriteBrands.class))).thenReturn(favoritebrands);

        FavoriteBrandsDTO result = favoritebrandsService.updateFavoriteBrands(favoritebrandsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateFavoriteBrands_NotFound() {
        when(favoritebrandsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoritebrandsService.updateFavoriteBrands(favoritebrandsDTO);
        });

        assertEquals("id = " + favoritebrandsDTO.getFavoriteBrandId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteFavoriteBrands_Found() throws Exception {
        when(favoritebrandsRepository.findById(anyInt())).thenReturn(Optional.of(favoritebrands));
        when(favoritebrandsRepository.save(any(FavoriteBrands.class)))
                .thenReturn(new FavoriteBrands());
        String result = favoritebrandsService.deleteFavoriteBrands(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteFavoriteBrands_NotFound() {
        when(favoritebrandsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            favoritebrandsService.deleteFavoriteBrands(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static FavoriteBrandsDTO generateRandomFavoriteBrands() {
		FavoriteBrandsDTO record = new FavoriteBrandsDTO();
		record.setFavoriteBrandId(2);
		record.setBrandId(Randomizer.randomInt(1000));
		record.setLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
    public static FavoriteBrands generateRandomFavoriteBrandsEntity() {
		FavoriteBrands record = new FavoriteBrands();
		record.setFavoriteBrandId(2);
		record.setBrandId(Randomizer.randomInt(1000));
		record.setIsLocal(Randomizer.randomBoolean());
		record.setActv(Randomizer.randomString(2));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}

}
