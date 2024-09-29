package com.schnarbiesnmeowers.nmsmonolith.repositories.workouts;

import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.WorkoutCardio;
import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.WorkoutSteps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface WorkoutStepsRepository extends JpaRepository<WorkoutSteps, Integer> {

    @Query(value = "select * from workout_steps wrk where wrk.user_id = ?1 and wrk.calendar_date >= ?2 ", nativeQuery = true)
    public Iterable<WorkoutSteps> findWorkoutStepsByUserIdAndDate(int userId, LocalDate date);
}
