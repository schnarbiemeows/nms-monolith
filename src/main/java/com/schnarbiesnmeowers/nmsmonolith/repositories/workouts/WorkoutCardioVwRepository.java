package com.schnarbiesnmeowers.nmsmonolith.repositories.workouts;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutCardioVw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutCardioVwRepository extends JpaRepository<WorkoutCardioVw, Integer> {

    @Query(value = "select * from workout_cardio_vw wrk where wrk.user_id = ?1 and wrk.calendar_date >= ?2 ", nativeQuery = true)
    public Iterable<WorkoutCardioVw> findWorkoutCardioByUserIdAndDate(int userId, String date);
}
