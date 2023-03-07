package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GoalEvent;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface GoalEventRepository extends JpaRepository<GoalEvent, Integer> {


	/**
	 * get Iterable<GoalEvent> by foreign key : userId
	 * @param userId
	 * @return Iterable<GoalEvent>
	*/
	public Iterable<GoalEvent> findGoalEventByUserId(int userId);
	/**
	 * get Iterable<GoalEvent> by foreign key : goalId
	 * @param goalId
	 * @return Iterable<GoalEvent>
	*/
	public Iterable<GoalEvent> findGoalEventByGoalId(int goalId);
	/**
	 * get Iterable<GoalEvent> by foreign key : eventId
	 * @param eventId
	 * @return Iterable<GoalEvent>
	*/
	public Iterable<GoalEvent> findGoalEventByEventId(int eventId);
	/**
	 * get Iterable<GoalEvent> by all foreign keys
	 * @return Iterable<GoalEvent>
	*/
	public Iterable<GoalEvent> findGoalEventByUserIdAndGoalIdAndEventId(int userId,int goalId,int eventId);
}
