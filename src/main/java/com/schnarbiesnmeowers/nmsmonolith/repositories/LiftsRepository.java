package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Lifts;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LiftsRepository extends JpaRepository<Lifts, Integer> {


	/**
	 * get Iterable<Lifts> by foreign key : muscleId
	 * @param muscleId
	 * @return Iterable<Lifts>
	*/
	public Iterable<Lifts> findLiftsByMuscleId(int muscleId);
	/**
	 * get Iterable<Lifts> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<Lifts>
	*/
	public Iterable<Lifts> findLiftsByImageLoc(int imageLoc);
	/**
	 * get Iterable<Lifts> by all foreign keys
	 * @return Iterable<Lifts>
	*/
	public Iterable<Lifts> findLiftsByMuscleIdAndImageLoc(int muscleId,int imageLoc);
}
