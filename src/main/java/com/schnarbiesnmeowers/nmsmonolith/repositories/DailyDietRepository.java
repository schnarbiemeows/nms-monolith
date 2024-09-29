package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyDiet;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface DailyDietRepository extends JpaRepository<DailyDiet, Integer> {


	/**
	 * get Iterable<DailyDiet> by foreign key : userId
	 * @param userId
	 * @return Iterable<DailyDiet>
	*/
	public Iterable<DailyDiet> findDailyDietByUserId(int userId);
	/**
	 * get Iterable<DailyDiet> by foreign key : ingrId
	 * @param ingrId
	 * @return Iterable<DailyDiet>
	*/
	public Iterable<DailyDiet> findDailyDietByIngrId(int ingrId);
	/**
	 * get Iterable<DailyDiet> by foreign key : bldstId
	 * @param bldstId
	 * @return Iterable<DailyDiet>
	*/
	public Iterable<DailyDiet> findDailyDietByBldstId(int bldstId);
	/**
	 * get Iterable<DailyDiet> by all foreign keys
	 * @return Iterable<DailyDiet>
	*/
	public Iterable<DailyDiet> findDailyDietByUserIdAndIngrIdAndBldstId(int userId,int ingrId,int bldstId);

	@Query(value = "select * from daily_diet dd where dd.user_id = ?1 and dd.calendar_date = ?2 " +
			"order by dd.bldst_id, dd.time_eaten", nativeQuery = true)
	public Iterable<DailyDiet> findDailyDietByUserIdAndDate(int userId, Date date);

	/**
	 *
	 * @param recipeId
	 * @return
	 */
	@Query(value = "select * from daily_diet dd " +
			"where dd.ingr_id = ?1 and dd.is_recipe=true " +
			"and dd.is_local=true ", nativeQuery = true)
	public Iterable<DailyDiet> findDailyDietRecordsWithLocalRecipeId(int recipeId);

	/**
	 *
	 * @param recipeId
	 * @return
	 */
	@Query(value = "select * from daily_diet dd " +
			"where dd.ingr_id = ?1 and dd.is_recipe=true " +
			"and dd.is_local=false ", nativeQuery = true)
	public Iterable<DailyDiet> findDailyDietRecordsWithGlobalRecipeId(int recipeId);

	/**
	 *
	 * @param ingrId
	 * @return
	 */
	@Query(value = "select * from daily_diet dd " +
			"where dd.ingr_id = ?1 and dd.is_recipe=false " +
			"and dd.is_local=true ", nativeQuery = true)
	public Iterable<DailyDiet> findDailyDietRecordsThatHaveLocalIngredientId(int ingrId);

	/**
	 *
	 * @param ingrId
	 * @return
	 */
	@Query(value = "select * from daily_diet dd " +
			"where dd.ingr_id = ?1 and dd.is_recipe=false " +
			"and dd.is_local=false ", nativeQuery = true)
	public Iterable<DailyDiet> findDailyDietRecordsThatHaveGlobalIngredientId(int ingrId);
}
