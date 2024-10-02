package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.PeriodExt;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface PeriodExtRepository extends JpaRepository<PeriodExt, Integer> {


	/**
	 * get Iterable<PeriodExt> by foreign key : periodId
	 * @param periodId
	 * @return Iterable<PeriodExt>
	*/
	public Iterable<PeriodExt> findPeriodExtByPeriodId(int periodId);
}
