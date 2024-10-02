package com.schnarbiesnmeowers.nmsmonolith.repositories.workouts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.Workouts;
import org.springframework.data.jpa.repository.Query;

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
	@Query(value = "select * from workouts wrk where wrk.user_id = ?1 and wrk.calendar_date = ?2 ", nativeQuery = true)
	public Iterable<Workouts> findWorkoutsByUserIdAndDate(int userId, String date);

}
