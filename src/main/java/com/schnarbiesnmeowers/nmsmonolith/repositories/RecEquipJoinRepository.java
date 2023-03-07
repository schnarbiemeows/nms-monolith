package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecEquipJoin;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RecEquipJoinRepository extends JpaRepository<RecEquipJoin, Integer> {


	/**
	 * get Iterable<RecEquipJoin> by foreign key : recipeId
	 * @param recipeId
	 * @return Iterable<RecEquipJoin>
	*/
	public Iterable<RecEquipJoin> findRecEquipJoinByRecipeId(int recipeId);
	/**
	 * get Iterable<RecEquipJoin> by foreign key : recipeEquipId
	 * @param recipeEquipId
	 * @return Iterable<RecEquipJoin>
	*/
	public Iterable<RecEquipJoin> findRecEquipJoinByRecipeEquipId(int recipeEquipId);
	/**
	 * get Iterable<RecEquipJoin> by all foreign keys
	 * @return Iterable<RecEquipJoin>
	*/
	public Iterable<RecEquipJoin> findRecEquipJoinByRecipeIdAndRecipeEquipId(int recipeId,int recipeEquipId);
}
