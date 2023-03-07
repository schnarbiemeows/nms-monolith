package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalRecipes;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LocalRecipesRepository extends JpaRepository<LocalRecipes, Integer>{

    @Query(value = "select * from local_recipes lr where lr.user_id = ?1 and lr.actv='Y'", nativeQuery = true)
    public Iterable<LocalRecipes> findLocalRecipesByUserId(int userId);
}
