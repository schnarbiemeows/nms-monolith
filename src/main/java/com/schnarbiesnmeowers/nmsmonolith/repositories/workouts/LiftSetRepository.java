package com.schnarbiesnmeowers.nmsmonolith.repositories.workouts;

import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.LiftSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiftSetRepository extends JpaRepository<LiftSet, Integer> {

    /**
     * get Iterable<WorkoutCardio> by foreign key : workoutId
     * @param workoutLiftId
     * @return Iterable<WorkoutCardio>
     */
    public Iterable<LiftSet> findLiftSetByWorkoutLiftId(int workoutLiftId);
}
