package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface FavoriteRecipesRepository extends JpaRepository<FavoriteRecipes, Integer>{

    @Query(value = "select * from favorite_recipes fr where fr.user_id = ?1 and fr.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteRecipes> findFavoriteRecipesByUserId(int userId);

    @Query(value = "select * from favorite_recipes fr where fr.user_id = ?1 and fr.is_local=true and fr.recipe_id=?2 and fr.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteRecipes> findLocalRecipesInAnyUserFavorites(int userId, int recipeId);

    @Query(value = "select * from favorite_recipes fr where fr.is_local=false and fr.recipe_id=?1 and fr.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteRecipes> findGlobalRecipesInAnyUserFavorites(int recipeId);

    @Query(value = "select * from favorite_recipes fr where fr.is_local=true and fr.recipe_id=?1", nativeQuery = true)
    public FavoriteRecipes findFavoriteLocalRecipeForUser(int recipeId);

    @Query(value = "select * from favorite_recipes fr where fr.is_local=false and fr.recipe_id=?1", nativeQuery = true)
    public FavoriteRecipes findFavoriteGlobalRecipeForUser(int recipeId);
}
