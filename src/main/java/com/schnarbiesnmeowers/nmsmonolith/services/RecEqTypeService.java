package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEqTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecEqType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecEqTypeRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecEqTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecEqTypeRepository recEqTypeRepository;

	/**
	 * get all RecEqType records
	 * @return
	 * @throws Exception
	 */
	public List<RecEqTypeDTO> getAllRecEqType() throws Exception {
		Iterable<RecEqType> receqtype = recEqTypeRepository.findAll();
		Iterator<RecEqType> receqtypes = receqtype.iterator();
		List<RecEqTypeDTO> receqtypedto = new ArrayList();
		while(receqtypes.hasNext()) {
			RecEqType item = receqtypes.next();
			receqtypedto.add(item.toDTO());
		}
		return receqtypedto;
	}

	/**
	 * get RecEqType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecEqTypeDTO findRecEqTypeById(int id) throws Exception {
		Optional<RecEqType> receqtypeOptional = recEqTypeRepository.findById(id);
		if(receqtypeOptional.isPresent()) {
			RecEqType results = receqtypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new RecEqType
	 * @param data
	 * @return
	 */
	public RecEqTypeDTO createRecEqType(RecEqTypeDTO data) {
		try {
		    RecEqType createdData = data.toEntity();
		    createdData = recEqTypeRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecEqType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecEqTypeDTO updateRecEqType(RecEqTypeDTO data) throws Exception {
		Optional<RecEqType> receqtypeOptional = recEqTypeRepository.findById(data.getRecEqTypeId());
		if(receqtypeOptional.isPresent()) {
		    RecEqType updatedData = data.toEntity();
			updatedData = recEqTypeRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecEqTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a RecEqType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecEqType(int id) throws Exception {
		Optional<RecEqType> receqtypeOptional = recEqTypeRepository.findById(id);
		if(receqtypeOptional.isPresent()) {
			recEqTypeRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
