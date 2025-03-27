package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteIngredients;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface FavoriteIngredientsRepository extends JpaRepository<FavoriteIngredients, Integer>{

    @Query(value = "select * from favorite_ingredients fi where fi.user_id = ?1 and fi.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteIngredients> findFavoriteIngredientsByUserId(int userId);

    @Query(value = "select * from favorite_ingredients fi where fi.user_id = ?1 and fi.is_local=true and fi.ingr_id=?2 and fi.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteIngredients> findLocalIngredientsInAnyUserFavorites(int userId, int ingredientId);

    @Query(value = "select * from favorite_ingredients fi where fi.is_local=false and fi.ingr_id=?1 and fi.actv='Y'", nativeQuery = true)
    public Iterable<FavoriteIngredients> findGlobalIngredientsInAnyUserFavorites(int ingredientId);
}
