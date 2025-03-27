package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeFormDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.RecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Ingredients;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteRecipesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Recipes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RecipesServiceTest {

    @Mock
    private RecipesRepository recipesRepository;

    @Mock
    IngredientsService ingredientsService;

    @Mock
    private LocalRecipesService localRecipesService;

    @Mock
    RecipeStepsService recipeStepsService;

    @Mock
    private FavoriteRecipesRepository favoriteRecipesRepository;

    @Mock
    private FavoriteRecipesService favoriteRecipesService;

    @Mock
    RecipeIngredientsService recipeIngredientsService;

    @Mock
    RecipeSpicesService recipeSpicesService;

    @Mock
    LocalRecipeIngredientsService localRecipeIngredientsService;

    @Mock
    DailyDietService dailyDietService;

    @InjectMocks
    private RecipesService recipesService;

    private Recipes recipes;
    private RecipeFormDTO recipesDTO;

    @BeforeEach
    void setUp() {
        recipes = generateRandomRecipesEntity();
        recipesDTO = generateRandomRecipeForm();
    }

    @Test
    void testGetAllRecipes() throws Exception {
        when(recipesRepository.findAll()).thenReturn(Collections.singletonList(recipes));

        List<RecipesDTO> result = recipesService.getAllRecipes();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRecipesById_Found() throws Exception {
        when(recipesRepository.findById(anyInt())).thenReturn(Optional.of(recipes));
        when(ingredientsService.findIngredientsById(anyInt()))
                .thenReturn(new IngredientsDTO());
        RecipeFormDTO result = recipesService.findRecipesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRecipesById_NotFound() {
        when(recipesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipesService.findRecipesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRecipes() throws Exception {
        when(recipesRepository.save(any(Recipes.class))).thenReturn(recipes);
        when(ingredientsService.createIngredients(any(IngredientsDTO.class)))
                .thenReturn(new IngredientsDTO());
        RecipesDTO result = recipesService.createRecipe(recipesDTO);
        assertNotNull(result);
    }

    @Test
    void testUpdateRecipes_Found() throws Exception {
        when(recipesRepository.findById(anyInt())).thenReturn(Optional.of(recipes));
        when(recipesRepository.save(any(Recipes.class))).thenReturn(recipes);
        when(ingredientsService.updateIngredientRecordForRecipe(any()))
                .thenReturn(new IngredientsDTO());
        RecipesDTO result = recipesService.updateRecipe(recipesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecipes_NotFound() {
        when(recipesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipesService.updateRecipe(recipesDTO);
        });

        assertEquals("id = " + recipesDTO.getRecipeMetaData().getRecipeId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteRecipes_Found() throws Exception {
        when(recipesRepository.findById(anyInt())).thenReturn(Optional.of(recipes));
        when(recipesRepository.save(any())).thenReturn(recipes);
        when(recipeIngredientsService.deleteRecipeIngredientsForaGlobalRecipe(anyInt()))
                .thenReturn(0);
        when(recipeSpicesService.deleteRecipeSpicesForaGlobalRecipe(anyInt()))
                .thenReturn(0);
        when(recipeStepsService.deleteRecipeStepsForaGlobalRecipe(anyInt()))
                .thenReturn(0);
        when(ingredientsService.deleteIngredientRecordForRecipe(anyInt()))
                .thenReturn("OK");
        when(localRecipeIngredientsService
                .findLocalRecipesThatAreDependentUponGivenGlobalRecipe(anyInt()))
                .thenReturn(new ArrayList<>());
        when(dailyDietService.findDailyDietRecordsWithGlobalRecipeId(anyInt()))
                .thenReturn(new ArrayList<>());
        String result = recipesService.deleteRecipe(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRecipes_NotFound() {
        when(recipesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recipesService.deleteRecipe(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RecipeFormDTO generateRandomRecipeForm() {
        RecipeFormDTO record = new RecipeFormDTO();
		record.setFavor(false);
        record.setLocal(false);
        record.setRecipeSteps(new ArrayList<>());
        record.setRecipeSpices(new ArrayList<>());
        record.setUserId(Randomizer.randomInt(9));
        record.setRecipeIngredients(new ArrayList<>());
        record.setServingTypeId(Randomizer.randomInt(9));
        record.setServingSize(Randomizer.randomBigDecimal("3"));
        RecipesDTO dto = new RecipesDTO();
        dto.setRecipeId(2);
        record.setRecipeMetaData(dto);
		return record;
	}
    public static Recipes generateRandomRecipesEntity() {
		Recipes record = new Recipes();
		record.setRecipeId(2);
		record.setRecipeName(Randomizer.randomString(20));
		record.setRecipeTypeId(Randomizer.randomInt(1000));
		record.setIngrId(Randomizer.randomInt(1000));
		record.setRecipeDesc(Randomizer.randomString(20));
		record.setRecipeLink(Randomizer.randomString(20));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setActv(Randomizer.randomString(2));
		return record;
	}


}
