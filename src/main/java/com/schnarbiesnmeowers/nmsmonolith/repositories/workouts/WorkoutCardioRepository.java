package com.schnarbiesnmeowers.nmsmonolith.repositories.workouts;

import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyWeight;
import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.WorkoutCardio;
import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.WorkoutCardio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutCardioRepository extends JpaRepository<WorkoutCardio, Integer> {

    /**
     * get Iterable<WorkoutCardio> by foreign key : workoutId
     * @param workoutId
     * @return Iterable<WorkoutCardio>
     */
    public Iterable<WorkoutCardio> findWorkoutCardioByWorkoutId(int workoutId);

    /**
     *
     * @param userId
     * @param dateStr
     * @return
     */
    @Query(value = "select dw.* from daily_weight dw where dw.user_id=?1 and dw.calendar_date >= ?2 order by dw.calendar_date", nativeQuery = true)
    public Iterable<WorkoutCardio> findDailyWeightByUserIdAndDate(int userId, String dateStr);
}
