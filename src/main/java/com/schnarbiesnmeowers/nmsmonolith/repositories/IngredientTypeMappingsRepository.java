package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.IngredientTypeMappings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientTypeMappingsRepository extends JpaRepository<IngredientTypeMappings, Integer> {

    @Query(value="select * from ingredient_type_mappings", nativeQuery = true)
    public List<IngredientTypeMappings> getIngredientTypeMappings() ;
}