package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.Rda;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface RdaRepository extends JpaRepository<Rda, Integer> {


	/**
	 * get Iterable<Rda> by foreign key : userId
	 * @param userId
	 * @return Iterable<Rda>
	*/
	public Iterable<Rda> findRdaByUserId(int userId);

	@Query(value = "select * from rda rd where rd.user_id=1 and rd.actv = 'Y'", nativeQuery = true)
	public Iterable<Rda> findDefaults();

	@Query(value = "select * from rda rd where rd.user_id=?1 and rd.actv = 'Y'", nativeQuery = true)
	public Iterable<Rda> findActiveRdasByUserId(int userId);
}
