package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Unsynced;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface UnsyncedRepository extends JpaRepository<Unsynced, Integer>{


	/**
	 * get Iterable<Unsynced> by foreign key : userId
	 * @param userId
	 * @return Iterable<Unsynced>
	*/
	public Iterable<Unsynced> findUnsyncedByUserId(int userId);

	@Query(value="select * from unsynced u where u.user_id=?1 and u.calendar_date = ?2" , nativeQuery = true)
	public Optional<Unsynced> findUnsynchedRecordByUserIdAndCalendarDate(int userId, Date calendarDate);
}
