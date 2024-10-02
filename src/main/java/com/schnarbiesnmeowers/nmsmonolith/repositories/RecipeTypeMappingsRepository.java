package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeTypeMappings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeTypeMappingsRepository extends JpaRepository<RecipeTypeMappings, Integer> {

    @Query(value="select * from recipe_type_mappings", nativeQuery = true)
    public List<RecipeTypeMappings> getRecipeTypeMappings() ;
}
