package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.LocalRecipeSteps;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LocalRecipeStepsRepository extends JpaRepository<LocalRecipeSteps, Integer>{


	/**
	 * get Iterable<LocalRecipeSteps> by foreign key : recipeId
	 * @param recipeId
	 * @return Iterable<LocalRecipeSteps>
	*/
	@Query(value = "select * from local_recipe_steps lrs where lrs.actv='Y' and lrs.recipe_id = ?1 order by lrs.step_num", nativeQuery = true)
	public Iterable<LocalRecipeSteps> findLocalRecipeStepsByRecipeId(int recipeId);
	/**
	 * get Iterable<LocalRecipeSteps> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<LocalRecipeSteps>
	*/
	public Iterable<LocalRecipeSteps> findLocalRecipeStepsByImageLoc(int imageLoc);
	/**
	 * get Iterable<LocalRecipeSteps> by all foreign keys
	 * @return Iterable<LocalRecipeSteps>
	*/
	public Iterable<LocalRecipeSteps> findLocalRecipeStepsByRecipeIdAndImageLoc(int recipeId,int imageLoc);

	@Transactional
	@Modifying
	@Query(value = "update local_recipe_steps lrs set lrs.actv='N' where lrs.recipe_id = ?1 " +
			"and lrs.actv='Y'", nativeQuery = true)
	public int deleteLocalRecipeStepsByRecipeId(int recipeId);
}
