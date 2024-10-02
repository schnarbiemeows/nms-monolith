package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.BloodPressure;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface BloodPressureRepository extends JpaRepository<BloodPressure, Integer>{


	/**
	 * get Iterable<BloodPressure> by foreign key : userId
	 * @param userId
	 * @return Iterable<BloodPressure>
	*/
	public Iterable<BloodPressure> findBloodPressureByUserId(int userId);
}
