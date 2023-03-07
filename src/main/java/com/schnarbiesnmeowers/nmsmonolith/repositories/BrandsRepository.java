package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Brands;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface BrandsRepository extends JpaRepository<Brands, Integer> {


	/**
	 * get Iterable<Brands> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<Brands>
	*/
	public Iterable<Brands> findBrandsByImageLoc(int imageLoc);

	@Query(value = "select * from brands b where b.actv='Y' order by b.brand_name", nativeQuery = true)
	public Iterable<Brands> findActiveBrands();
}
