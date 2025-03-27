package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeType;

import java.util.List;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RecipeTypeRepository extends JpaRepository<RecipeType, Integer> {

    @Query(value = "select * from recipe_type rt where rt.actv = 'Y'", nativeQuery = true)
    public List<RecipeType> getAllActiveRecipeTypes();

}
