package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Spices;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface SpicesRepository extends JpaRepository<Spices, Integer>{


	/**
	 * get Iterable<Spices> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<Spices>
	*/
	public Iterable<Spices> findSpicesByImageLoc(int imageLoc);

	@Query(value = "select * from spices sp where sp.actv='Y' order by sp.spice_name", nativeQuery = true)
	public Iterable<Spices> findAllActiveGlobalSpices();

}
