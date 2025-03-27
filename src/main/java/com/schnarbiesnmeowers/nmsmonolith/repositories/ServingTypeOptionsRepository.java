package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeOptions;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface ServingTypeOptionsRepository extends JpaRepository<ServingTypeOptions, Integer>{


	/**
	 * get Iterable<ServingTypeOptions> by foreign key : servTypeId
	 * @param id
	 * @return Iterable<ServingTypeOptions>
	*/
	public Iterable<ServingTypeOptions> findServingTypeOptionsByServTypeId(int servTypeId);
	/**
	 * get Iterable<ServingTypeOptions> by foreign key : menuOption
	 * @param id
	 * @return Iterable<ServingTypeOptions>
	*/
	public Iterable<ServingTypeOptions> findServingTypeOptionsByMenuOption(int menuOption);
	/**
	 * get Iterable<ServingTypeOptions> by all foreign keys
	 * @return Iterable<ServingTypeOptions>
	*/
	public Iterable<ServingTypeOptions> findServingTypeOptionsByServTypeIdAndMenuOption(int servTypeId,int menuOption);
}
