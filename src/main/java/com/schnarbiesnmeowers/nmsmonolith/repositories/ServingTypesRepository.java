package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypes;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface ServingTypesRepository extends JpaRepository<ServingTypes, Integer> {


	/**
	 * get Iterable<ServingTypes> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<ServingTypes>
	*/
	public Iterable<ServingTypes> findServingTypesByImageLoc(int imageLoc);

	@Query(value = "select * from serving_types st where st.actv='Y'", nativeQuery = true)
	public Iterable<ServingTypes> findActiveServingTypes();

	@Query(value = "select * from serving_types st where st.serv_type_cde='tsp' and st.actv='Y'", nativeQuery = true)
	public Optional<ServingTypes> findServingTypeForTsp();
}
