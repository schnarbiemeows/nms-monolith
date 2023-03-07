package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.WrktRecs;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface WrktRecsRepository extends JpaRepository<WrktRecs, Integer> {


	/**
	 * get Iterable<WrktRecs> by foreign key : workoutId
	 * @param workoutId
	 * @return Iterable<WrktRecs>
	*/
	public Iterable<WrktRecs> findWrktRecsByWorkoutId(int workoutId);
	/**
	 * get Iterable<WrktRecs> by foreign key : liftId
	 * @param liftId
	 * @return Iterable<WrktRecs>
	*/
	public Iterable<WrktRecs> findWrktRecsByLiftId(int liftId);
	/**
	 * get Iterable<WrktRecs> by all foreign keys
	 * @return Iterable<WrktRecs>
	*/
	public Iterable<WrktRecs> findWrktRecsByWorkoutIdAndLiftId(int workoutId,int liftId);
}
