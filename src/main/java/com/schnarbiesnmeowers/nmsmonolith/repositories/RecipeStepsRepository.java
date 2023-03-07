package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecipeSteps;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RecipeStepsRepository extends JpaRepository<RecipeSteps, Integer> {


	/**
	 * get Iterable<RecipeSteps> by foreign key : recipeId
	 * @param recipeId
	 * @return Iterable<RecipeSteps>
	*/
	@Query(value = "select * from recipe_steps rs where rs.actv='Y' and rs.recipe_id = ?1 order by rs.step_num", nativeQuery = true)
	public Iterable<RecipeSteps> findRecipeStepsByRecipeId(int recipeId);
	/**
	 * get Iterable<RecipeSteps> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<RecipeSteps>
	*/
	public Iterable<RecipeSteps> findRecipeStepsByImageLoc(int imageLoc);
	/**
	 * get Iterable<RecipeSteps> by all foreign keys
	 * @return Iterable<RecipeSteps>
	*/
	public Iterable<RecipeSteps> findRecipeStepsByRecipeIdAndImageLoc(int recipeId,int imageLoc);

	@Transactional
	@Modifying
	@Query(value = "update recipe_steps rs set rs.actv='N' where rs.recipe_id = ?1 " +
			"and rs.actv='Y'", nativeQuery = true)
	public int deleteRecipeStepsByRecipeId(int recipeId);
}
