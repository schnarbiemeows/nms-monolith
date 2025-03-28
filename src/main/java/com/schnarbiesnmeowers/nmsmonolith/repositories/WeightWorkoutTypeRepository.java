package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WeightWorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightWorkoutTypeRepository extends JpaRepository<WeightWorkoutType,Integer> {

    public WeightWorkoutType findByWorkoutId(int workoutId);
}
