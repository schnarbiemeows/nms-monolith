package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeSpices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RecipeSpicesRepository extends JpaRepository<RecipeSpices, Integer>{


	/**
	 * get Iterable<RecipeSpices> by foreign key : recipeId
	 * @param recipeId
	 * @return Iterable<RecipeSpices>
	*/
	@Query(value = "select * from recipe_spices rs where rs.recipe_id = ?1 " +
			"and rs.actv='Y'", nativeQuery = true)
	public Iterable<RecipeSpices> findRecipeSpicesByRecipeId(int recipeId);
	/**
	 * get Iterable<RecipeSpices> by foreign key : spiceId
	 * @param spiceId
	 * @return Iterable<RecipeSpices>
	*/
	public Iterable<RecipeSpices> findRecipeSpicesBySpiceId(int spiceId);

	@Transactional
	@Modifying
	@Query(value = "update recipe_spices rs set rs.actv='N' where rs.recipe_id = ?1 " +
			"and rs.actv='Y'", nativeQuery = true)
	public int deleteRecipeSpicesByRecipeId(int recipeId);

	@Query(value = "select * from recipe_spices rs where rs.spice_id = ?1 " +
			"and rs.actv='Y'", nativeQuery = true)
	public Iterable<RecipeSpices> findGlobalRecipesThatAreDependentUponThisGlobalSpice(int spiceId);

	
}
