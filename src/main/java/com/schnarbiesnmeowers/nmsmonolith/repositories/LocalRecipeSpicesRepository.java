package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.LocalRecipeSpices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LocalRecipeSpicesRepository extends JpaRepository<LocalRecipeSpices, Integer>{


	/**
	 * get Iterable<LocalRecipeSpices> by foreign key : recipeId
	 * @param recipeId
	 * @return Iterable<LocalRecipeSpices>
	*/
	public Iterable<LocalRecipeSpices> findLocalRecipeSpicesByRecipeId(int recipeId);
	/**
	 * get Iterable<LocalRecipeSpices> by foreign key : servTypeId
	 * @param servTypeId
	 * @return Iterable<LocalRecipeSpices>
	*/
	public Iterable<LocalRecipeSpices> findLocalRecipeSpicesByServTypeId(int servTypeId);
	/**
	 * get Iterable<LocalRecipeSpices> by all foreign keys
	 * @return Iterable<LocalRecipeSpices>
	*/
	public Iterable<LocalRecipeSpices> findLocalRecipeSpicesByRecipeIdAndServTypeId(int recipeId,int servTypeId);

	@Query(value = "select * from local_recipe_spices lrs where lrs.user_id = ?1 and lrs.actv='Y'", nativeQuery = true)
	public Iterable<LocalRecipeSpices> findLocalRecipeSpicesByUserId(int userId);

	@Query(value = "select * from local_recipe_spices lrs where lrs.user_id = ?1 " +
			"and lrs.recipe_id=?2 and lrs.actv='Y'", nativeQuery = true)
	public Iterable<LocalRecipeSpices> findLocalRecipeSpicesByRecipeIdandUserId(int userId, int recipeId);

	@Query(value = "select * from local_recipe_spices lrs where lrs.user_id = ?1 and lrs.spice_id = ?2 " +
			"and lrs.is_local = true and lrs.actv='Y' ", nativeQuery = true)
	public Iterable<LocalRecipeSpices>
	findLocalRecipesThatAreDependentUponGivenLocalSpice(int userId, int spiceId);

	@Query(value = "select * from local_recipe_spices lrs where lrs.spice_id = ?1 " +
			"and lrs.is_local = false and lrs.actv='Y'", nativeQuery = true)
	public Iterable<LocalRecipeSpices>
	findLocalRecipesThatAreDependentUponGivenGlobalSpice(int spiceId);

	@Transactional
	@Modifying
	@Query(value = "update local_recipe_spices lrs set lrs.actv='N' where lrs.recipe_id=?1 " +
			"and lrs.user_id = ?2 and lrs.actv='Y'", nativeQuery = true)
	public int deleteRecipeSpicesByRecipeIdAndUserId(int recipeId, int userId);
}
