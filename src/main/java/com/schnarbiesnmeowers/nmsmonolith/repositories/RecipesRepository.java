package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Recipes;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RecipesRepository extends JpaRepository<Recipes, Integer> {


	/**
	 * get Iterable<Recipes> by foreign key : ingrId
	 * @param ingrId
	 * @return Iterable<Recipes>
	*/
	public Iterable<Recipes> findRecipesByIngrId(int ingrId);

	@Query(value = "select * from recipes r where r.actv='Y' order by r.recipe_name" , nativeQuery = true)
	public Iterable<Recipes> findAllActiveRecipes();
}
