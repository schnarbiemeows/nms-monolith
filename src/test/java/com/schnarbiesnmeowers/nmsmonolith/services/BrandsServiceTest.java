package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandsDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class BrandsServiceTest {


	/**
	 * get all Brands records
	 * @return
	 * @throws Exception
	 */
	public List<BrandsDTO> getAllBrands() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<BrandsDTO> brandsDTO = new ArrayList<BrandsDTO>();
		return brandsDTO;
	}

	/**
	 * get Brands by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BrandsDTO findBrandsById(int id) throws Exception {
		return new BrandsDTO();
	}

	/**
	 * create a new Brands
	 * @param data
	 * @return
	 */
	public BrandsDTO createBrands(BrandsDTO data) {
        data.setBrandId(1);
        return data;
	}

	/**
	 * update a Brands
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public BrandsDTO updateBrands(BrandsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Brands by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBrands(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<BrandsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<Brands>
	 * @throws Exception
	*/
	public List<BrandsDTO> findBrandsByImageLoc(int id) throws Exception {
		List<BrandsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
