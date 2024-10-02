package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalGroups;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface GoalGroupsRepository extends JpaRepository<GoalGroups, Integer> {


	/**
	 * get Iterable<GoalGroups> by foreign key : goalId1
	 * @param goalId1
	 * @return Iterable<GoalGroups>
	*/
	public Iterable<GoalGroups> findGoalGroupsByGoalId1(int goalId1);
	/**
	 * get Iterable<GoalGroups> by foreign key : goalId2
	 * @param goalId2
	 * @return Iterable<GoalGroups>
	*/
	public Iterable<GoalGroups> findGoalGroupsByGoalId2(int goalId2);
	/**
	 * get Iterable<GoalGroups> by all foreign keys
	 * @return Iterable<GoalGroups>
	*/
	public Iterable<GoalGroups> findGoalGroupsByGoalId1AndGoalId2(int goalId1,int goalId2);
}
