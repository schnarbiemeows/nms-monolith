package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeMinDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypesRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ServingTypesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ServingTypesRepository servingTypesRepository;

	/**
	 * get all ServingTypes records
	 * @return
	 * @throws Exception
	 */
	public List<ServingTypesDTO> getAllServingTypes() throws Exception {
		Iterable<ServingTypes> servingtypes = servingTypesRepository.findActiveServingTypes();
		Iterator<ServingTypes> servingtypess = servingtypes.iterator();
		List<ServingTypesDTO> servingtypesdto = new ArrayList();
		while(servingtypess.hasNext()) {
			ServingTypes item = servingtypess.next();
			servingtypesdto.add(item.toDTO());
		}
		return servingtypesdto;
	}

	/**
	 * get ServingTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ServingTypesDTO findServingTypesById(int id) throws Exception {
		Optional<ServingTypes> servingtypesOptional = servingTypesRepository.findById(id);
		if(servingtypesOptional.isPresent()) {
			ServingTypes results = servingtypesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public int findServingTypeForTsp() throws Exception {
		Optional<ServingTypes> servingtypesOptional = servingTypesRepository.findServingTypeForTsp();
		if(servingtypesOptional.isPresent()) {
			ServingTypes results = servingtypesOptional.get();
			return results.getServTypeId();
		} else {
			return 1;
		}
	}

	/**
	 * create a new ServingTypes
	 * @param data
	 * @return
	 */
	public ServingTypesDTO createServingTypes(ServingTypesDTO data) {
		try {
		    ServingTypes createdData = data.toEntity();
		    createdData = servingTypesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ServingTypes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ServingTypesDTO updateServingTypes(ServingTypesDTO data) throws Exception {
		Optional<ServingTypes> servingtypesOptional = servingTypesRepository.findById(data.getServTypeId());
		if(servingtypesOptional.isPresent()) {
		    ServingTypes updatedData = data.toEntity();
			updatedData = servingTypesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getServTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a ServingTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteServingTypes(int id) throws Exception {
		Optional<ServingTypes> servingtypesOptional = servingTypesRepository.findById(id);
		if(servingtypesOptional.isPresent()) {
			servingTypesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<ServingTypesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<ServingTypes>
	 * @throws Exception
	*/
	public List<ServingTypesDTO> findServingTypesByImageLoc(int id) throws Exception {
		Iterable<ServingTypes> results = servingTypesRepository.findServingTypesByImageLoc(id);
		Iterator<ServingTypes> iter = results.iterator();
		List<ServingTypesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ServingTypes item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public List<ServingTypeMinDataDTO> getMinServingTypeData() {
		Iterable<ServingTypes> servingTypes = servingTypesRepository.findActiveServingTypes();
		Iterator<ServingTypes> iter = servingTypes.iterator();
		List<ServingTypeMinDataDTO> minData = new ArrayList();
		while(iter.hasNext()) {
			ServingTypes item = iter.next();
			minData.add(new ServingTypeMinDataDTO(item.getServTypeId(),item.getServTypeCde()));
		}
		return minData;
	}
}
