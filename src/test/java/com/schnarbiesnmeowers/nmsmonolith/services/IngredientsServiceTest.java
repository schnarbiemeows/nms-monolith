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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Ingredients;
import com.schnarbiesnmeowers.nmsmonolith.repositories.IngredientsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class IngredientsServiceTest {

    @Mock
    private IngredientsRepository ingredientsRepository;

    @Mock
    private FavoriteIngredientsService favoriteIngredientsService;

    @Mock
    private RecipeIngredientsService recipeIngredientsService;

    @Mock
    DailyDietService dailyDietService;

    @Mock
    private LocalRecipeIngredientsService localRecipeIngredientsService;


    @InjectMocks
    private IngredientsService ingredientsService;

    private Ingredients ingredients;
    private IngredientsDTO ingredientsDTO;

    @BeforeEach
    void setUp() {
        ingredients = generateRandomIngredientsEntity();
        ingredientsDTO = generateRandomIngredients();
    }

    @Test
    void testGetAllIngredients() throws Exception {
        when(ingredientsRepository.findAllActiveIngredients(anyInt())).thenReturn(Collections.singletonList(ingredients));

        List<IngredientsDTO> result = ingredientsService.getAllIngredients();

        assertEquals(1, result.size());
    }

    @Test
    void testFindIngredientsById_Found() throws Exception {
        when(ingredientsRepository.findById(anyInt())).thenReturn(Optional.of(ingredients));

        IngredientsDTO result = ingredientsService.findIngredientsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindIngredientsById_NotFound() {
        when(ingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            ingredientsService.findIngredientsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateIngredients() {
        when(ingredientsRepository.save(any(Ingredients.class))).thenReturn(ingredients);

        IngredientsDTO result = ingredientsService.createIngredients(ingredientsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateIngredients_Found() throws Exception {
        when(ingredientsRepository.findById(anyInt())).thenReturn(Optional.of(ingredients));
        when(ingredientsRepository.save(any(Ingredients.class))).thenReturn(ingredients);

        IngredientsDTO result = ingredientsService.updateIngredients(ingredientsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateIngredients_NotFound() {
        when(ingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            ingredientsService.updateIngredients(ingredientsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteIngredients_Found() throws Exception {
        when(ingredientsRepository.findById(anyInt())).thenReturn(Optional.of(ingredients));
        when(ingredientsRepository.save(any())).thenReturn(ingredients);
        when(favoriteIngredientsService
                .checkForFavoriteDependencies(anyInt(),isNull(),eq(false)))
                .thenReturn(false);
        when(recipeIngredientsService
                .checkForGlobalRecipesThatAreDependentUponThisGlobalIngredient(anyInt()))
                .thenReturn(false);
        when(dailyDietService
                .findDailyDietRecordsWithGlobalIngredientId(anyInt()))
                .thenReturn(new ArrayList<>());
        String result = ingredientsService.deleteIngredients(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteIngredients_NotFound() {
        when(ingredientsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            ingredientsService.deleteIngredients(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static IngredientsDTO generateRandomIngredients() {
		IngredientsDTO record = new IngredientsDTO();
		record.setIngrId(2);
		record.setIngrDesc(Randomizer.randomString(20));
		record.setIngrTypeId(Randomizer.randomInt(1000));
		record.setBrandId(Randomizer.randomInt(1000));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setKcalories(Randomizer.randomBigDecimal("1000"));
		record.setTotFat(Randomizer.randomBigDecimal("1000"));
		record.setSatFat(Randomizer.randomBigDecimal("1000"));
		record.setTransFat(Randomizer.randomBigDecimal("1000"));
		record.setPolyFat(Randomizer.randomBigDecimal("1000"));
		record.setMonoFat(Randomizer.randomBigDecimal("1000"));
		record.setCholes(Randomizer.randomBigDecimal("1000"));
		record.setSodium(Randomizer.randomInt(1000));
		record.setTotCarbs(Randomizer.randomBigDecimal("1000"));
		record.setTotFiber(Randomizer.randomBigDecimal("1000"));
		record.setTotSugars(Randomizer.randomBigDecimal("1000"));
		record.setTotProtein(Randomizer.randomBigDecimal("1000"));
		record.setGlycIndx(Randomizer.randomBigDecimal("1000"));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Ingredients generateRandomIngredientsEntity() {
		Ingredients record = new Ingredients();
		record.setIngrId(2);
		record.setIngrDesc(Randomizer.randomString(20));
		record.setIngrTypeId(Randomizer.randomInt(1000));
		record.setBrandId(Randomizer.randomInt(1000));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setKcalories(Randomizer.randomBigDecimal("1000"));
		record.setTotFat(Randomizer.randomBigDecimal("1000"));
		record.setSatFat(Randomizer.randomBigDecimal("1000"));
		record.setTransFat(Randomizer.randomBigDecimal("1000"));
		record.setPolyFat(Randomizer.randomBigDecimal("1000"));
		record.setMonoFat(Randomizer.randomBigDecimal("1000"));
		record.setCholes(Randomizer.randomBigDecimal("1000"));
		record.setSodium(Randomizer.randomInt(1000));
		record.setTotCarbs(Randomizer.randomBigDecimal("1000"));
		record.setTotFiber(Randomizer.randomBigDecimal("1000"));
		record.setTotSugars(Randomizer.randomBigDecimal("1000"));
		record.setTotProtein(Randomizer.randomBigDecimal("1000"));
		record.setGlycIndx(Randomizer.randomBigDecimal("1000"));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
