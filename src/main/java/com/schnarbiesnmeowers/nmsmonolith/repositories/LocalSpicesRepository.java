package com.schnarbiesnmeowers.nmsmonolith.repositories;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalSpices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalSpices;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface LocalSpicesRepository extends JpaRepository<LocalSpices, Integer>{


	/**
	 * get Iterable<LocalSpices> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<LocalSpices>
	*/
	public Iterable<LocalSpices> findLocalSpicesByImageLoc(int imageLoc);

	@Query(value = "select * from local_spices ls where ls.user_id = ?1 " +
			"and ls.actv='Y' order by ls.spice_name", nativeQuery = true)
	public Iterable<LocalSpices> findLocalSpicesByUserId(int userId);

}
