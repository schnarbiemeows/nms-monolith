package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietaryNotes;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface DailyDietaryNotesRepository extends JpaRepository<DailyDietaryNotes, Integer> {


	/**
	 * get Iterable<DailyDietaryNotes> by foreign key : userId
	 * @param userId
	 * @return Iterable<DailyDietaryNotes>
	*/
	public Iterable<DailyDietaryNotes> findDailyDietaryNotesByUserId(int userId);

	@Query(value = "select * from daily_dietary_notes ddn where ddn.user_id= ?1 " +
			"and ddn.calendar_date=?2",nativeQuery = true)
	public Optional<DailyDietaryNotes> findDailyDietaryNotesByUserIdAndDate(int userId, Date date);
}
