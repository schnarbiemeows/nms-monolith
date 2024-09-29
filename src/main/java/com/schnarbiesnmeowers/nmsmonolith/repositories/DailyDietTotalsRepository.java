package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyDietTotals;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface DailyDietTotalsRepository extends JpaRepository<DailyDietTotals, Integer> {


	/**
	 * get Iterable<DailyDietTotals> by foreign key : userId
	 * @param userId
	 * @return Iterable<DailyDietTotals>
	*/
	public Iterable<DailyDietTotals> findDailyDietTotalsByUserId(int userId);
	/**
	 * get Iterable<DailyDietTotals> by foreign key : bldstId
	 * @param bldstId
	 * @return Iterable<DailyDietTotals>
	*/
	public Iterable<DailyDietTotals> findDailyDietTotalsByBldstId(int bldstId);
	/**
	 * get Iterable<DailyDietTotals> by all foreign keys
	 * @return Iterable<DailyDietTotals>
	*/
	public Iterable<DailyDietTotals> findDailyDietTotalsByUserIdAndBldstId(int userId,int bldstId);

	@Query(value = "select ddt.* from daily_diet_totals ddt, bldst_table b " +
			"where ddt.user_id=?1 " +
			"and ddt.bldst_id = b.bldst_table_id " +
			"and ddt.calendar_date = ?2 order by b.order_by", nativeQuery = true)
	public Iterable<DailyDietTotals> findDailyDietTotalsByUserIdAndCalendarDate(int userId, Date calendarDate);

	@Query(value = "select * from daily_diet_totals ddt where ddt.user_id=?1 " +
			"and ddt.calendar_date = ?2 and ddt.bldst_id = ?3 ", nativeQuery = true)
	public Optional<DailyDietTotals> findDailyDietTotalsByUserIdAndCalendarDateAndBldstId(int userId,
			Date calendarDate, int bldstId);
}
