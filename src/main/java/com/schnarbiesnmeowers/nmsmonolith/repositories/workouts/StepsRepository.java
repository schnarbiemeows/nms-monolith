package com.schnarbiesnmeowers.nmsmonolith.repositories.workouts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.Steps;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface StepsRepository extends JpaRepository<Steps, Integer> {


	/**
	 * get Iterable<Steps> by foreign key : workoutId
	 * @param workoutId
	 * @return Iterable<Steps>
	*/
	public Iterable<Steps> findStepsByWorkoutId(int workoutId);

}
