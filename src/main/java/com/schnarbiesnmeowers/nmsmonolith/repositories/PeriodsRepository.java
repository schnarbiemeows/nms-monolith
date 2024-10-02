package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.Periods;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface PeriodsRepository extends JpaRepository<Periods, Integer> {


	/**
	 * get Iterable<Periods> by foreign key : periodTypeId
	 * @param periodTypeId
	 * @return Iterable<Periods>
	*/
	public Iterable<Periods> findPeriodsByPeriodTypeId(int periodTypeId);
}
