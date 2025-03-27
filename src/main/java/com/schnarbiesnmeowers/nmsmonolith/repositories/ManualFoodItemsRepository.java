package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.ManualFoodItems;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface ManualFoodItemsRepository extends JpaRepository<ManualFoodItems, Integer>{


	/**
	 * get Iterable<ManualFoodItems> by foreign key : userId
	 * @param id
	 * @return Iterable<ManualFoodItems>
	*/
	public Iterable<ManualFoodItems> findManualFoodItemsByUserId(int userId);
	/**
	 * get Iterable<ManualFoodItems> by foreign key : bldstId
	 * @param id
	 * @return Iterable<ManualFoodItems>
	*/
	public Iterable<ManualFoodItems> findManualFoodItemsByBldstId(int bldstId);
	/**
	 * get Iterable<ManualFoodItems> by foreign key : servTypeId
	 * @param id
	 * @return Iterable<ManualFoodItems>
	*/
	public Iterable<ManualFoodItems> findManualFoodItemsByServTypeId(int servTypeId);
	/**
	 * get Iterable<ManualFoodItems> by all foreign keys
	 * @return Iterable<ManualFoodItems>
	*/
	public Iterable<ManualFoodItems> findManualFoodItemsByUserIdAndBldstIdAndServTypeId(int userId,int bldstId,int servTypeId);
}
