package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.LocalRecipes;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LocalRecipesRepository extends JpaRepository<LocalRecipes, Integer>{

    @Query(value = "select * from local_recipes lr where lr.user_id = ?1 and lr.actv='Y'", nativeQuery = true)
    public Iterable<LocalRecipes> findLocalRecipesByUserId(int userId);

    @Query(value = "select r.* from local_recipes r, local_ingredients i where r.ingr_id = i.ingr_id " +
            "and i.actv='Y' order by i.tot_protein/i.kcalories desc;", nativeQuery = true)
    public Iterable<LocalRecipes> findRecipesByProtein(int userId);

    @Query(value = "select r.* from local_recipes r, local_ingredients i where r.ingr_id = i.ingr_id " +
            "and i.actv='Y' order by i.tot_fat/i.kcalories desc;", nativeQuery = true)
    public Iterable<LocalRecipes> findRecipesByFats(int userId);

    @Query(value = "select r.* from local_recipes r, local_ingredients i where r.ingr_id = i.ingr_id " +
            "and i.actv='Y' order by i.mono_fat/i.kcalories desc;", nativeQuery = true)
    public Iterable<LocalRecipes> findRecipesByMonoFats(int userId);

    @Query(value = "select r.* from local_recipes r, local_ingredients i where r.ingr_id = i.ingr_id " +
            "and i.actv='Y' order by i.tot_carbs/i.kcalories desc;", nativeQuery = true)
    public Iterable<LocalRecipes> findRecipesByCarbs(int userId);

    @Query(value = "select r.* from local_recipes r, local_ingredients i where r.ingr_id = i.ingr_id " +
            "and i.actv='Y' order by i.tot_fiber/i.kcalories desc;", nativeQuery = true)
    public Iterable<LocalRecipes> findRecipesByFiber(int userId);
}
