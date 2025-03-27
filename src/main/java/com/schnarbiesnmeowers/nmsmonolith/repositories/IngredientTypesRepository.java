package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.IngredientTypes;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface IngredientTypesRepository extends JpaRepository<IngredientTypes, Integer> {


	/**
	 * get Iterable<IngredientTypes> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<IngredientTypes>
	*/
	public Iterable<IngredientTypes> findIngredientTypesByImageLoc(int imageLoc);

	@Query( value = "select it.ingr_type_id from ingredient_types it where it.ingr_type_desc = 'recipe' and it.actv='Y'", nativeQuery = true)
	public Integer findTheIngredientTypeForRecipe();

	@Query( value = "select * from ingredient_types it where it.actv='Y' order by it.ingr_type_desc", nativeQuery = true)
	public List<IngredientTypes> findActiveIngredientTypes();
}
