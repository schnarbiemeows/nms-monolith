package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.BrandIngrType;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface BrandIngrTypeRepository extends JpaRepository<BrandIngrType, Integer> {


	/**
	 * get Iterable<BrandIngrType> by foreign key : brandId
	 * @param brandId
	 * @return Iterable<BrandIngrType>
	*/
	public Iterable<BrandIngrType> findBrandIngrTypeByBrandId(int brandId);
	/**
	 * get Iterable<BrandIngrType> by foreign key : ingrTypeId
	 * @param ingrTypeId
	 * @return Iterable<BrandIngrType>
	*/
	public Iterable<BrandIngrType> findBrandIngrTypeByIngrTypeId(int ingrTypeId);
	/**
	 * get Iterable<BrandIngrType> by foreign key : prntIngrType
	 * @param prntIngrType
	 * @return Iterable<BrandIngrType>
	*/
	public Iterable<BrandIngrType> findBrandIngrTypeByPrntIngrType(int prntIngrType);
	/**
	 * get Iterable<BrandIngrType> by all foreign keys
	 * @return Iterable<BrandIngrType>
	*/
	public Iterable<BrandIngrType> findBrandIngrTypeByBrandIdAndIngrTypeIdAndPrntIngrType(int brandId,int ingrTypeId,int prntIngrType);
}
