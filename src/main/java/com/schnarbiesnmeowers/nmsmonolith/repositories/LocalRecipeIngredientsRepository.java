package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.LocalRecipeIngredients;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LocalRecipeIngredientsRepository extends JpaRepository<LocalRecipeIngredients, Integer>{

    @Query(value = "select * from local_recipe_ingredients lri where lri.user_id = ?1 and lri.actv='Y'", nativeQuery = true)
    public Iterable<LocalRecipeIngredients> findLocalRecipeIngredientsByUserId(int userId);

    /**
     * BECAUSE RECIPE_ID pk'S ARE UNIQUE WITHIN LOCAL_RECIPES, THERE IS NO NEED TO USE THE USER_ID
     * 	 * IN THIS SEARCH
     * this query will return local recipes that are dependent on a given local recipe
     * but only for a given user
     * @param recipeId
     * @return
     */
    @Query(value = "select * from local_recipe_ingredients lri where " +
            "lri.rec_or_ingr_id=?1 and lri.local_recp_ingr = true " +
            "and lri.recipe_flg='Y' and lri.actv='Y'", nativeQuery = true)
    public Iterable<LocalRecipeIngredients>
    findLocalRecipesThatAreDependentUponGivenLocalRecipe(int recipeId);

    /**
     * this query will return local recipes that are dependent on a given global recipe
     * @param recipeId
     * @return
     */
    @Query(value = "select * from local_recipe_ingredients lri where lri.rec_or_ingr_id=?1 " +
            "and lri.recipe_flg='Y' and lri.local_recp_ingr = false " +
            "and lri.actv='Y'", nativeQuery = true)
    public Iterable<LocalRecipeIngredients>
    findLocalRecipesThatAreDependentUponGivenGlobalRecipe(int recipeId);

    /**
     * BECAUSE RECIPE_ID pk'S ARE UNIQUE WITHIN LOCAL_RECIPES, THERE IS NO NEED TO USE THE USER_ID
     * IN THIS SEARCH
     * @param recipeId
     * @return
     */
    @Query(value = "select * from local_recipe_ingredients lri where lri.recipe_id=?1" +
            " and lri.actv='Y'", nativeQuery = true)
    public Iterable<LocalRecipeIngredients> findLocalRecipeIngredientsByRecipeId(int recipeId);

    @Query(value = "select * from local_recipe_ingredients lri where lri.rec_or_ingr_id = ?1 " +
            "and lri.local_recp_ingr = true and lri.recipe_flg = 'N' and lri.actv='Y' ", nativeQuery = true)
    public Iterable<LocalRecipeIngredients>
    findLocalRecipesThatAreDependentUponGivenLocalIngredient(int ingredientId);

    @Query(value = "select * from local_recipe_ingredients lri where lri.rec_or_ingr_id = ?1 " +
            "and lri.local_recp_ingr = false and lri.actv='Y' and lri.recipe_flg = 'N'", nativeQuery = true)
    public Iterable<LocalRecipeIngredients>
    findLocalRecipesThatAreDependentUponGivenGlobalIngredient(int ingredientId);

    @Transactional
    @Modifying
    @Query(value = "update local_recipe_ingredients lri set lri.actv='N' where lri.recipe_id=?1 " +
            "and lri.user_id = ?2 and lri.actv='Y'", nativeQuery = true)
    public int deleteRecipeIngredientsByRecipeIdAndUserId(int recipeId, int userId);
}
