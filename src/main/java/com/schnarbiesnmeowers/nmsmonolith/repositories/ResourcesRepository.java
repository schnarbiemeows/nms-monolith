package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Resources;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface ResourcesRepository extends JpaRepository<Resources, Integer> {


	/**
	 * get Iterable<Resources> by foreign key : rsrcTypeId
	 * @param rsrcTypeId
	 * @return Iterable<Resources>
	*/
	public Iterable<Resources> findResourcesByRsrcTypeId(int rsrcTypeId);
}
