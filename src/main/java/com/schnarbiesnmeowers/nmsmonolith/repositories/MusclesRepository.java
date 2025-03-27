package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.Muscles;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface MusclesRepository extends JpaRepository<Muscles, Integer> {


	/**
	 * get Iterable<Muscles> by foreign key : muscleGroupId
	 * @param muscleGroupId
	 * @return Iterable<Muscles>
	*/
	public Iterable<Muscles> findMusclesByMuscleGroupId(int muscleGroupId);
	/**
	 * get Iterable<Muscles> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<Muscles>
	*/
	public Iterable<Muscles> findMusclesByImageLoc(int imageLoc);
	/**
	 * get Iterable<Muscles> by all foreign keys
	 * @return Iterable<Muscles>
	*/
	public Iterable<Muscles> findMusclesByMuscleGroupIdAndImageLoc(int muscleGroupId,int imageLoc);
}
