package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.QuickIngredientsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuickIngredientsListRepository extends JpaRepository<QuickIngredientsList,Integer> {

    @Query(value = "select * from quick_ingredient_list qil where qil.meal_type_id =?1" +
            " and qil.user_id = ?2 order by qil.ingredient_desc, qil.quantity", nativeQuery = true)
    public Iterable<QuickIngredientsList> findAllQuickIngredientsForMealType(int mealTypeId, int userId);
}
