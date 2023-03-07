package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.PeriodType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodTypeRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PeriodTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PeriodTypeRepository periodTypeRepository;

	/**
	 * get all PeriodType records
	 * @return
	 * @throws Exception
	 */
	public List<PeriodTypeDTO> getAllPeriodType() throws Exception {
		Iterable<PeriodType> periodtype = periodTypeRepository.findAll();
		Iterator<PeriodType> periodtypes = periodtype.iterator();
		List<PeriodTypeDTO> periodtypedto = new ArrayList();
		while(periodtypes.hasNext()) {
			PeriodType item = periodtypes.next();
			periodtypedto.add(item.toDTO());
		}
		return periodtypedto;
	}

	/**
	 * get PeriodType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PeriodTypeDTO findPeriodTypeById(int id) throws Exception {
		Optional<PeriodType> periodtypeOptional = periodTypeRepository.findById(id);
		if(periodtypeOptional.isPresent()) {
			PeriodType results = periodtypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new PeriodType
	 * @param data
	 * @return
	 */
	public PeriodTypeDTO createPeriodType(PeriodTypeDTO data) {
		try {
		    PeriodType createdData = data.toEntity();
		    createdData = periodTypeRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a PeriodType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PeriodTypeDTO updatePeriodType(PeriodTypeDTO data) throws Exception {
		Optional<PeriodType> periodtypeOptional = periodTypeRepository.findById(data.getPeriodTypeId());
		if(periodtypeOptional.isPresent()) {
		    PeriodType updatedData = data.toEntity();
			updatedData = periodTypeRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getPeriodTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a PeriodType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePeriodType(int id) throws Exception {
		Optional<PeriodType> periodtypeOptional = periodTypeRepository.findById(id);
		if(periodtypeOptional.isPresent()) {
			periodTypeRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
