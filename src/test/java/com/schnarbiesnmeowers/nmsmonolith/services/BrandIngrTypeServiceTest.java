package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BrandIngrTypeDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class BrandIngrTypeServiceTest {


	/**
	 * get all BrandIngrType records
	 * @return
	 * @throws Exception
	 */
	public List<BrandIngrTypeDTO> getAllBrandIngrType() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<BrandIngrTypeDTO> brandingrtypeDTO = new ArrayList<BrandIngrTypeDTO>();
		return brandingrtypeDTO;
	}

	/**
	 * get BrandIngrType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BrandIngrTypeDTO findBrandIngrTypeById(int id) throws Exception {
		return new BrandIngrTypeDTO();
	}

	/**
	 * create a new BrandIngrType
	 * @param data
	 * @return
	 */
	public BrandIngrTypeDTO createBrandIngrType(BrandIngrTypeDTO data) {
        data.setBrandIngrTypeId(1);
        return data;
	}

	/**
	 * update a BrandIngrType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public BrandIngrTypeDTO updateBrandIngrType(BrandIngrTypeDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a BrandIngrType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBrandIngrType(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : brandId
	 * @param brandId
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	public List<BrandIngrTypeDTO> findBrandIngrTypeByBrandId(int id) throws Exception {
		List<BrandIngrTypeDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : ingrTypeId
	 * @param ingrTypeId
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	public List<BrandIngrTypeDTO> findBrandIngrTypeByIngrTypeId(int id) throws Exception {
		List<BrandIngrTypeDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : prntIngrType
	 * @param prntIngrType
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	public List<BrandIngrTypeDTO> findBrandIngrTypeByPrntIngrType(int id) throws Exception {
		List<BrandIngrTypeDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : BrandIdAndIngrTypeIdAndPrntIngrType
	 * @param BrandIdAndIngrTypeIdAndPrntIngrType
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	public List<BrandIngrTypeDTO> findBrandIngrTypeByBrandIdAndIngrTypeIdAndPrntIngrType(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		List<BrandIngrTypeDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
