package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Goals;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface GoalsRepository extends JpaRepository<Goals, Integer> {


	/**
	 * get Iterable<Goals> by foreign key : userId
	 * @param userId
	 * @return Iterable<Goals>
	*/
	public Iterable<Goals> findGoalsByUserId(int userId);
	/**
	 * get Iterable<Goals> by foreign key : gcId
	 * @param gcId
	 * @return Iterable<Goals>
	*/
	public Iterable<Goals> findGoalsByGcId(int gcId);
	/**
	 * get Iterable<Goals> by all foreign keys
	 * @return Iterable<Goals>
	*/
	public Iterable<Goals> findGoalsByUserIdAndGcId(int userId,int gcId);
}
