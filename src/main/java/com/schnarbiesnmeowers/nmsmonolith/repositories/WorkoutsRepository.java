package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Workouts;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface WorkoutsRepository extends JpaRepository<Workouts, Integer> {


	/**
	 * get Iterable<Workouts> by foreign key : userId
	 * @param userId
	 * @return Iterable<Workouts>
	*/
	public Iterable<Workouts> findWorkoutsByUserId(int userId);
	/**
	 * get Iterable<Workouts> by foreign key : exerciseTypeId
	 * @param exerciseTypeId
	 * @return Iterable<Workouts>
	*/
	public Iterable<Workouts> findWorkoutsByExerciseTypeId(int exerciseTypeId);
	/**
	 * get Iterable<Workouts> by all foreign keys
	 * @return Iterable<Workouts>
	*/
	public Iterable<Workouts> findWorkoutsByUserIdAndExerciseTypeId(int userId,int exerciseTypeId);
}
