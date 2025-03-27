package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeIngredients;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeIngredientsRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 *
 * @author Dylan I. Kessler
 */
@Service
public class RecipeIngredientsService {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    /**
     * JPA Repository handle
     */
    @Autowired
    private RecipeIngredientsRepository recipeIngredientsRepository;

    /**
     * get all RecipeIngredients records
     *
     * @return
     * @throws Exception
     */
    public List<RecipeIngredientsDTO> getAllRecipeIngredients() throws Exception {
        Iterable<RecipeIngredients> recipeingredients = recipeIngredientsRepository.findAll();
        Iterator<RecipeIngredients> recipeingredientss = recipeingredients.iterator();
        List<RecipeIngredientsDTO> recipeingredientsdto = new ArrayList();
        while (recipeingredientss.hasNext()) {
            RecipeIngredients item = recipeingredientss.next();
            recipeingredientsdto.add(item.toDTO());
        }
        return recipeingredientsdto;
    }

    /**
     * get RecipeIngredients by primary key
     *
     * @param id
     * @return
     * @throws Exception
     */
    public RecipeIngredientsDTO findRecipeIngredientsById(int id) throws Exception {
        Optional<RecipeIngredients> recipeingredientsOptional = recipeIngredientsRepository.findById(id);
        if (recipeingredientsOptional.isPresent()) {
            RecipeIngredients results = recipeingredientsOptional.get();
            return results.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new RecipeIngredients
     *
     * @param data
     * @return
     */
    public RecipeIngredientsDTO createRecipeIngredients(RecipeIngredientsDTO data) {
        try {
            RecipeIngredients createdData = data.toEntity();
            createdData = recipeIngredientsRepository.save(createdData);
            return createdData.toDTO();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * update a RecipeIngredients
     *
     * @param data
     * @return
     * @throws Exception
     */
    public RecipeIngredientsDTO updateRecipeIngredients(RecipeIngredientsDTO data) throws Exception {
        Optional<RecipeIngredients> recipeingredientsOptional =
				recipeIngredientsRepository.findById(data.getRecipeIngrId());
        if (recipeingredientsOptional.isPresent()) {
            RecipeIngredients updatedData = data.toEntity();
            updatedData = recipeIngredientsRepository.save(updatedData);
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeIngrId() + NOT_FOUND);
        }
    }

    /**
     * delete a RecipeIngredients by primary key
     *
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteRecipeIngredients(int id) throws Exception {
        Optional<RecipeIngredients> recipeingredientsOptional = recipeIngredientsRepository.findById(id);
        if (recipeingredientsOptional.isPresent()) {
            recipeIngredientsRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * get List<RecipeIngredientsDTO> by foreign key : recipeId
     *
     * @param id
     * @return List<RecipeIngredients>
     * @throws Exception
     */
    public List<RecipeIngredientsDTO> findRecipeIngredientsByRecipeId(int id) throws Exception {
        Iterable<RecipeIngredients> results = recipeIngredientsRepository.findRecipeIngredientsByRecipeId(id);
        Iterator<RecipeIngredients> iter = results.iterator();
        List<RecipeIngredientsDTO> resultsdto = new ArrayList();
        while (iter.hasNext()) {
            RecipeIngredients item = iter.next();
            resultsdto.add(item.toDTO());
        }
        return resultsdto;
    }

    public int deleteRecipeIngredientsForaGlobalRecipe(int id) throws Exception {
        int result = recipeIngredientsRepository.deleteRecipeIngredientsByRecipeId(id);
        return result;
    }

    public boolean checkForGlobalRecipesThatAreDependentUponThisGlobalIngredient(int ingredientId) {
        Iterable<RecipeIngredients> dependencies = recipeIngredientsRepository
				.findGlobalRecipesThatAreDependentUponThisGlobalIngredient(ingredientId);
        if (dependencies != null && dependencies.iterator().hasNext()) {
            return true;
        }
        return false;
    }

    /**
     * this will find global recipes that are dependent on another global recipe
     * @param recipeId
     * @return
     */
    public List<RecipeIngredientsDTO> findParentRecipeIngredientsForaGlobalRecipe(Integer recipeId) {
        Iterable<RecipeIngredients> results = recipeIngredientsRepository
                .findGlobalRecipesThatAreDependentUponThisGlobalRecipe(recipeId);
        Iterator<RecipeIngredients> iter = results.iterator();
        List<RecipeIngredientsDTO> resultsdto = new ArrayList();
        while (iter.hasNext()) {
            RecipeIngredients item = iter.next();
            resultsdto.add(item.toDTO());
        }
        return resultsdto;
    }

    /**
     * this will find global recipes that are dependent on another global recipe
     * @param ingredientId
     * @return
     */
    public List<RecipeIngredientsDTO> findParentRecipeIngredientsForaGlobalIngredient(Integer ingredientId) {
        Iterable<RecipeIngredients> results = recipeIngredientsRepository
                .findGlobalRecipesThatAreDependentUponThisGlobalIngredient(ingredientId);
        Iterator<RecipeIngredients> iter = results.iterator();
        List<RecipeIngredientsDTO> resultsdto = new ArrayList();
        while (iter.hasNext()) {
            RecipeIngredients item = iter.next();
            resultsdto.add(item.toDTO());
        }
        return resultsdto;
    }
}
