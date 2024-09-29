package com.schnarbiesnmeowers.nmsmonolith.repositories.workouts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.WorkoutLift;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface WorkoutLiftRepository extends JpaRepository<WorkoutLift, Integer> {


	/**
	 * get Iterable<WorkoutLift> by foreign key : workoutId
	 * @param workoutId
	 * @return Iterable<WorkoutLift>
	*/
	public Iterable<WorkoutLift> findWorkoutLiftByWorkoutId(int workoutId);
	/**
	 * get Iterable<WorkoutLift> by foreign key : liftId
	 * @param liftId
	 * @return Iterable<WorkoutLift>
	*/
	public Iterable<WorkoutLift> findWorkoutLiftByLiftId(int liftId);
	/**
	 * get Iterable<WorkoutLift> by all foreign keys
	 * @return Iterable<WorkoutLift>
	*/
	public Iterable<WorkoutLift> findWorkoutLiftByWorkoutIdAndLiftId(int workoutId,int liftId);
}
