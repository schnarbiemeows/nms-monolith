package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeRatios;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface ServingTypeRatiosRepository extends JpaRepository<ServingTypeRatios, Integer> {


	/**
	 * get Iterable<ServingTypeRatios> by foreign key : servTypeId1
	 * @param servTypeId1
	 * @return Iterable<ServingTypeRatios>
	*/
	public Iterable<ServingTypeRatios> findServingTypeRatiosByServTypeId1(int servTypeId1);
	/**
	 * get Iterable<ServingTypeRatios> by foreign key : servTypeId2
	 * @param servTypeId2
	 * @return Iterable<ServingTypeRatios>
	*/
	public Iterable<ServingTypeRatios> findServingTypeRatiosByServTypeId2(int servTypeId2);
	/**
	 * get Iterable<ServingTypeRatios> by all foreign keys
	 * @return Iterable<ServingTypeRatios>
	*/
	public Iterable<ServingTypeRatios> findServingTypeRatiosByServTypeId1AndServTypeId2(int servTypeId1,int servTypeId2);

	@Query(value = "select * from serving_type_ratios str order by str.serv_type_id_1,str.serv_type_id_2" , nativeQuery = true)
	public List<ServingTypeRatios> findAllAndOrder();
}
