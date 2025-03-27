package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.EventsTable;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface EventsTableRepository extends JpaRepository<EventsTable, Integer> {


	/**
	 * get Iterable<EventsTable> by foreign key : userId
	 * @param userId
	 * @return Iterable<EventsTable>
	*/
	public Iterable<EventsTable> findEventsTableByUserId(int userId);
	/**
	 * get Iterable<EventsTable> by foreign key : periodId
	 * @param periodId
	 * @return Iterable<EventsTable>
	*/
	public Iterable<EventsTable> findEventsTableByPeriodId(int periodId);
	/**
	 * get Iterable<EventsTable> by all foreign keys
	 * @return Iterable<EventsTable>
	*/
	public Iterable<EventsTable> findEventsTableByUserIdAndPeriodId(int userId,int periodId);
}
