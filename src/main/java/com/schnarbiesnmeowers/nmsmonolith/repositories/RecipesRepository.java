package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.Recipes;
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

	@Query(value = "select r.* from recipes r, ingredients i where r.ingr_id = i.ingr_id " +
			"and i.actv='Y' order by i.tot_protein/i.kcalories desc;", nativeQuery = true)
	public Iterable<Recipes> findRecipesByProtein();

	@Query(value = "select r.* from recipes r, ingredients i where r.ingr_id = i.ingr_id " +
			"and i.actv='Y' order by i.tot_fat/i.kcalories desc;", nativeQuery = true)
	public Iterable<Recipes> findRecipesByFats();

	@Query(value = "select r.* from recipes r, ingredients i where r.ingr_id = i.ingr_id " +
			"and i.actv='Y' order by i.mono_fat/i.kcalories desc;", nativeQuery = true)
	public Iterable<Recipes> findRecipesByMonoFats();

	@Query(value = "select r.* from recipes r, ingredients i where r.ingr_id = i.ingr_id " +
			"and i.actv='Y' order by i.tot_cars/i.kcalories desc;", nativeQuery = true)
	public Iterable<Recipes> findRecipesByCarbs();

	@Query(value = "select r.* from recipes r, ingredients i where r.ingr_id = i.ingr_id " +
			"and i.actv='Y' order by i.tot_fiber/i.kcalories desc;", nativeQuery = true)
	public Iterable<Recipes> findRecipesByFiber();
}
