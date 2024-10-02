package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.schnarbiesnmeowers.nmsmonolith.dtos.IngredientTypeMappingsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypeMinDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.IngredientTypeMappings;
import com.schnarbiesnmeowers.nmsmonolith.repositories.IngredientTypeMappingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.IngredientTypes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.IngredientTypesRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class IngredientTypesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private IngredientTypesRepository ingredientTypesRepository;

	@Autowired
	private IngredientTypeMappingsRepository ingredientTypeMappingsRepository;

	/**
	 * get all IngredientTypes records
	 * @return
	 * @throws Exception
	 */
	public List<IngredientTypesDTO> getAllIngredientTypes() throws Exception {
		Iterable<IngredientTypes> ingredienttypes = ingredientTypesRepository.findActiveIngredientTypes();
		Iterator<IngredientTypes> ingredienttypess = ingredienttypes.iterator();
		List<IngredientTypesDTO> ingredienttypesdto = new ArrayList();
		while(ingredienttypess.hasNext()) {
			IngredientTypes item = ingredienttypess.next();
			ingredienttypesdto.add(item.toDTO());
		}
		return ingredienttypesdto;
	}

	/**
	 * get IngredientTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IngredientTypesDTO findIngredientTypesById(int id) throws Exception {
		Optional<IngredientTypes> ingredienttypesOptional = ingredientTypesRepository.findById(id);
		if(ingredienttypesOptional.isPresent()) {
			IngredientTypes results = ingredienttypesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new IngredientTypes
	 * @param data
	 * @return
	 */
	public IngredientTypesDTO createIngredientTypes(IngredientTypesDTO data) {
		try {
		    IngredientTypes createdData = data.toEntity();
		    createdData = ingredientTypesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a IngredientTypes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public IngredientTypesDTO updateIngredientTypes(IngredientTypesDTO data) throws Exception {
		Optional<IngredientTypes> ingredienttypesOptional = ingredientTypesRepository.findById(data.getIngrTypeId());
		if(ingredienttypesOptional.isPresent()) {
		    IngredientTypes updatedData = data.toEntity();
			updatedData = ingredientTypesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getIngrTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a IngredientTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteIngredientTypes(int id) throws Exception {
		Optional<IngredientTypes> ingredienttypesOptional = ingredientTypesRepository.findById(id);
		if(ingredienttypesOptional.isPresent()) {
			ingredientTypesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<IngredientTypesDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<IngredientTypes>
	 * @throws Exception
	*/
	public List<IngredientTypesDTO> findIngredientTypesByImageLoc(int id) throws Exception {
		Iterable<IngredientTypes> results = ingredientTypesRepository.findIngredientTypesByImageLoc(id);
		Iterator<IngredientTypes> iter = results.iterator();
		List<IngredientTypesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			IngredientTypes item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public List<IngredientTypeMinDTO> getMinIngredientTypeData() {
		List<IngredientTypes> ingredientTypes = ingredientTypesRepository.findActiveIngredientTypes();
		List<IngredientTypeMinDTO> minimumData = new ArrayList();
		for(IngredientTypes type: ingredientTypes) {
			minimumData.add(new IngredientTypeMinDTO(type.getIngrTypeId(), type.getIngrTypeDesc()));
		}
		return minimumData;
	}

	/**
	 *
	 * @return
	 */
	public List<IngredientTypeMappingsDTO> getIngredientTypeMappings() {
		List<IngredientTypeMappings> ingredientTypeMappings = ingredientTypeMappingsRepository.getIngredientTypeMappings();
		IngredientTypeMappings first = ingredientTypeMappings.get(0);
		System.out.println(first.toString());
		List<IngredientTypeMappingsDTO> results = ingredientTypeMappings.stream().map(rec ->
				rec.toDTO()).collect(Collectors.toList());
		return results;
	}
}
