package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecipeIngredients;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, Integer> {


	/**
	 * get Iterable<RecipeIngredients> by foreign key : recipeId
	 * @param recipeId
	 * @return Iterable<RecipeIngredients>
	*/
	@Query(value = "select * from recipe_ingredients ri where ri.recipe_id = ?1 " +
			"and ri.actv='Y'", nativeQuery = true)
	public Iterable<RecipeIngredients> findRecipeIngredientsByRecipeId(int recipeId);

	@Transactional
	@Modifying
	@Query(value = "update recipe_ingredients ri set ri.actv='N' where ri.recipe_id = ?1 " +
			"and ri.actv='Y'", nativeQuery = true)
	public int deleteRecipeIngredientsByRecipeId(int recipeId);

	@Query(value = "select * from recipe_ingredients ri where ri.rec_or_ingr_id = ?1 " +
			"and ri.actv='Y' and ri.recipe_flg = 'N'", nativeQuery = true)
	public Iterable<RecipeIngredients> findGlobalRecipesThatAreDependentUponThisGlobalIngredient(int ingredientId);

	/**
	 * this will find global recipes that are dependent on another global recipe
	 * @param recipeId
	 * @return
	 */
	@Query(value = "select * from recipe_ingredients ri where ri.rec_or_ingr_id=?1" +
			" and ri.recipe_flg='Y' and ri.actv='Y'", nativeQuery = true)
	public Iterable<RecipeIngredients> findGlobalRecipesThatAreDependentUponThisGlobalRecipe(int recipeId);
}
