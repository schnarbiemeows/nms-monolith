package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DietaryTemplates;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface DietaryTemplatesRepository extends JpaRepository<DietaryTemplates, Integer>{


	/**
	 * get Iterable<DietaryTemplates> by foreign key : userId
	 * @param userId
	 * @return Iterable<DietaryTemplates>
	*/
	@Query(value = "select * from dietary_templates dt where dt.user_id=?1",nativeQuery = true)
	public Iterable<DietaryTemplates> findDietaryTemplatesByUserId(int userId);

	@Query(value = "select * from dietary_templates dt where dt.user_id=?1 " +
			"and dt.calendar_date = ?2",nativeQuery = true)
	public Iterable<DietaryTemplates> findDietaryTemplatesByUserIdAndCalendarDate(int userId, Date calendarDate);
}
