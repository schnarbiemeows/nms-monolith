package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BrandIngrTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.BrandIngrType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BrandIngrTypeRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class BrandIngrTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private BrandIngrTypeRepository brandIngrTypeRepository;

	/**
	 * get all BrandIngrType records
	 * @return
	 * @throws Exception
	 */
	public List<BrandIngrTypeDTO> getAllBrandIngrType() throws Exception {
		Iterable<BrandIngrType> brandingrtype = brandIngrTypeRepository.findAll();
		Iterator<BrandIngrType> brandingrtypes = brandingrtype.iterator();
		List<BrandIngrTypeDTO> brandingrtypedto = new ArrayList();
		while(brandingrtypes.hasNext()) {
			BrandIngrType item = brandingrtypes.next();
			brandingrtypedto.add(item.toDTO());
		}
		return brandingrtypedto;
	}

	/**
	 * get BrandIngrType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BrandIngrTypeDTO findBrandIngrTypeById(int id) throws Exception {
		Optional<BrandIngrType> brandingrtypeOptional = brandIngrTypeRepository.findById(id);
		if(brandingrtypeOptional.isPresent()) {
			BrandIngrType results = brandingrtypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new BrandIngrType
	 * @param data
	 * @return
	 */
	public BrandIngrTypeDTO createBrandIngrType(BrandIngrTypeDTO data) {
		try {
		    BrandIngrType createdData = data.toEntity();
		    createdData = brandIngrTypeRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a BrandIngrType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public BrandIngrTypeDTO updateBrandIngrType(BrandIngrTypeDTO data) throws Exception {
		Optional<BrandIngrType> brandingrtypeOptional = brandIngrTypeRepository.findById(data.getBrandIngrTypeId());
		if(brandingrtypeOptional.isPresent()) {
		    BrandIngrType updatedData = data.toEntity();
			updatedData = brandIngrTypeRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getBrandIngrTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a BrandIngrType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBrandIngrType(int id) throws Exception {
		Optional<BrandIngrType> brandingrtypeOptional = brandIngrTypeRepository.findById(id);
		if(brandingrtypeOptional.isPresent()) {
			brandIngrTypeRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : brandId
	 * @param brandId
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	public List<BrandIngrTypeDTO> findBrandIngrTypeByBrandId(int id) throws Exception {
		Iterable<BrandIngrType> results = brandIngrTypeRepository.findBrandIngrTypeByBrandId(id);
		Iterator<BrandIngrType> iter = results.iterator();
		List<BrandIngrTypeDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			BrandIngrType item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : ingrTypeId
	 * @param ingrTypeId
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	public List<BrandIngrTypeDTO> findBrandIngrTypeByIngrTypeId(int id) throws Exception {
		Iterable<BrandIngrType> results = brandIngrTypeRepository.findBrandIngrTypeByIngrTypeId(id);
		Iterator<BrandIngrType> iter = results.iterator();
		List<BrandIngrTypeDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			BrandIngrType item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : prntIngrType
	 * @param prntIngrType
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	public List<BrandIngrTypeDTO> findBrandIngrTypeByPrntIngrType(int id) throws Exception {
		Iterable<BrandIngrType> results = brandIngrTypeRepository.findBrandIngrTypeByPrntIngrType(id);
		Iterator<BrandIngrType> iter = results.iterator();
		List<BrandIngrTypeDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			BrandIngrType item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : BrandIdAndIngrTypeIdAndPrntIngrType
	 * @param BrandIdAndIngrTypeIdAndPrntIngrType
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	public List<BrandIngrTypeDTO> findBrandIngrTypeByBrandIdAndIngrTypeIdAndPrntIngrType(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		Iterable<BrandIngrType> results = brandIngrTypeRepository.findBrandIngrTypeByBrandIdAndIngrTypeIdAndPrntIngrType(id0, id1, id2);
		Iterator<BrandIngrType> iter = results.iterator();
		List<BrandIngrTypeDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			BrandIngrType item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
