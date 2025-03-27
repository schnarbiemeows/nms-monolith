package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeEquip;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RecipeEquipRepository extends JpaRepository<RecipeEquip, Integer> {


	/**
	 * get Iterable<RecipeEquip> by foreign key : recEqTypeId
	 * @param recEqTypeId
	 * @return Iterable<RecipeEquip>
	*/
	public Iterable<RecipeEquip> findRecipeEquipByRecEqTypeId(int recEqTypeId);
	/**
	 * get Iterable<RecipeEquip> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<RecipeEquip>
	*/
	public Iterable<RecipeEquip> findRecipeEquipByImageLoc(int imageLoc);
	/**
	 * get Iterable<RecipeEquip> by all foreign keys
	 * @return Iterable<RecipeEquip>
	*/
	public Iterable<RecipeEquip> findRecipeEquipByRecEqTypeIdAndImageLoc(int recEqTypeId,int imageLoc);
}
