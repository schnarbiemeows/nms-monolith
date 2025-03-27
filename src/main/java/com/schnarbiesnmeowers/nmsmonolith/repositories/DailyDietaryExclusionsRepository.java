package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietaryExclusions;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.Optional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface DailyDietaryExclusionsRepository extends JpaRepository<DailyDietaryExclusions, Integer>{


	/**
	 * get Iterable<DailyDietaryExclusions> by foreign key : userId
	 * @param userId
	 * @return Iterable<DailyDietaryExclusions>
	*/
	public Iterable<DailyDietaryExclusions> findDailyDietaryExclusionsByUserId(int userId);

	@Query(value = "select * from daily_dietary_exclusions dde where dde.user_id = ?1 " +
			"and dde.calendar_date = ?2", nativeQuery = true)
	public Optional<DailyDietaryExclusions> findDailyDietaryExclusionsByUserIdAndDate(int userId, Date date);
}
