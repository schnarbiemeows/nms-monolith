package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.Lifts;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LiftsRepository extends JpaRepository<Lifts, Integer> {

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

	@Query(value = "select * from lifts l order by l.muscle_group_id",nativeQuery = true)
	public Iterable<Lifts> getAllLiftsOrdered();
}
