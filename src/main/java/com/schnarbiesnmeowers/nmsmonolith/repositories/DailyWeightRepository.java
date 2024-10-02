package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyWeight;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface DailyWeightRepository extends JpaRepository<DailyWeight, Integer> {


	/**
	 * get Iterable<DailyWeight> by foreign key : userId
	 * @param userId
	 * @return Iterable<DailyWeight>
	*/
	public Iterable<DailyWeight> findDailyWeightByUserId(int userId);

	/**
	 *
	 * @param userId
	 * @return
	 */
	@Query(value = "select dw.* from daily_weight dw where dw.user_id=?1 order by dw.calendar_date", nativeQuery = true)
	public Iterable<DailyWeight> findSortedDailyWeightByUserId(int userId);

	/**
	 *
	 * @param userId
	 * @param dateStr
	 * @return
	 */
	@Query(value = "select dw.* from daily_weight dw where dw.user_id=?1 and dw.calendar_date >= ?2 order by dw.calendar_date", nativeQuery = true)
	public Iterable<DailyWeight> findDailyWeightByUserIdAndDate(int userId, String dateStr);
}
