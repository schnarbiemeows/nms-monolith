package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.ManualFoodItem;
import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.ManualFoodItemVw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManualFoodItemRepository extends JpaRepository<ManualFoodItem, Integer> {
}
