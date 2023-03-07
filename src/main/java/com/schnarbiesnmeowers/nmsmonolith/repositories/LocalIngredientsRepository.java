package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LocalIngredientsRepository extends JpaRepository<LocalIngredients, Integer> {


	public Iterable<LocalIngredients> findLocalIngredientsByImageLoc(Integer id);
	/**
	 * get Iterable<LocalIngredients> by foreign key : ingrTypeId
	 * @param ingrTypeId
	 * @return Iterable<LocalIngredients>
	*/
	public Iterable<LocalIngredients> findLocalIngredientsByIngrTypeId(int ingrTypeId);
	/**
	 * get Iterable<LocalIngredients> by foreign key : servTypeId
	 * @param servTypeId
	 * @return Iterable<LocalIngredients>
	*/
	public Iterable<LocalIngredients> findLocalIngredientsByServTypeId(int servTypeId);
	/**
	 * get Iterable<LocalIngredients> by all foreign keys
	 * @return Iterable<LocalIngredients>
	*/
	public Iterable<LocalIngredients> findLocalIngredientsByIngrTypeIdAndServTypeId(int ingrTypeId,int servTypeId);

	public Iterable<LocalIngredients> findLocalIngredientsByIngrTypeIdAndServTypeIdAndImageLoc(int ingrTypeId,int servTypeId, int imageLoc);
	@Query(value = "select * from local_ingredients li where li.user_id = ?1 " +
			"and li.ingr_type_id!=?2 and li.actv='Y' order by li.ingr_desc", nativeQuery = true)
	public Iterable<LocalIngredients> findLocalIngredientsByUserId(int userId, int ingr_typ_for_recipe);

	@Query(value = "select * from local_ingredients li where li.user_id = ?1 and " +
			"li.brand_id=?2 and li.ingr_type_id!=?3 and li.actv='Y' order by li.ingr_desc", nativeQuery = true)
	public Iterable<LocalIngredients> findLocalIngredientsByUserIdAndBrandId(int userId, int brandId,
																			 int ingr_typ_for_recipe);
}
