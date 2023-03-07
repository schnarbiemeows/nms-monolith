package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Ingredients;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {


	/**
	 * get Iterable<Ingredients> by foreign key : ingrTypeId
	 * @param ingrTypeId
	 * @return Iterable<Ingredients>
	*/
	public Iterable<Ingredients> findIngredientsByIngrTypeId(int ingrTypeId);
	/**
	 * get Iterable<Ingredients> by foreign key : brandId
	 * @param brandId
	 * @return Iterable<Ingredients>
	*/
	public Iterable<Ingredients> findIngredientsByBrandId(int brandId);
	/**
	 * get Iterable<Ingredients> by foreign key : servTypeId
	 * @param servTypeId
	 * @return Iterable<Ingredients>
	*/
	public Iterable<Ingredients> findIngredientsByServTypeId(int servTypeId);
	/**
	 * get Iterable<Ingredients> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<Ingredients>
	*/
	public Iterable<Ingredients> findIngredientsByImageLoc(int imageLoc);

	/**
	 * get Iterable<Ingredients> by foreign keys : ingrTypeId and brandId
	 * @param ingrTypeId
	 * @param brandId
	 * @return
	 */
	public Iterable<Ingredients> findIngredientsByIngrTypeIdAndBrandId(int ingrTypeId,int brandId);

	/**
	 * the purpose of ingr_typ_for_recipe here is, we want a list of all of the ingredient records
	 * OTHER THAN the ones that are there representing global recipes(which have type_id = 183)
	 * @param ingr_typ_for_recipe
	 * @return
	 */
	@Query(value = "select * from ingredients i where i.actv='Y' and i.ingr_type_id!=?1 " +
			"order by i.ingr_desc", nativeQuery = true)
	public Iterable<Ingredients> findAllActiveIngredients(int ingr_typ_for_recipe);
}
