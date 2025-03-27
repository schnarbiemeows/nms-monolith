package com.schnarbiesnmeowers.nmsmonolith.services.workouts;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WeightWorkoutType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WeightWorkoutTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.repositories.WeightWorkoutTypeRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class WeightWorkoutTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WeightWorkoutTypeRepository service;

	/**
	 * get all WeightWorkoutType records
	 * @return
	 * @throws Exception
	 */
	public List<WeightWorkoutTypeDTO> getAllWeightWorkoutType() throws Exception {
		Iterable<WeightWorkoutType> weightworkouttype = service.findAll();
		Iterator<WeightWorkoutType> weightworkouttypes = weightworkouttype.iterator();
		List<WeightWorkoutTypeDTO> weightworkouttypedto = new ArrayList();
		while(weightworkouttypes.hasNext()) {
			WeightWorkoutType item = weightworkouttypes.next();
			weightworkouttypedto.add(item.toDTO());
		}
		return weightworkouttypedto;
	}

	/**
	 * get WeightWorkoutType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public WeightWorkoutTypeDTO findWeightWorkoutTypeById(int id) throws Exception {
		Optional<WeightWorkoutType> weightworkouttypeOptional = service.findById(id);
		if(weightworkouttypeOptional.isPresent()) {
			WeightWorkoutType results = weightworkouttypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new WeightWorkoutType
	 * @param data
	 * @return
	 */
	public WeightWorkoutTypeDTO createWeightWorkoutType(WeightWorkoutTypeDTO data) {
		try {
		    WeightWorkoutType createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a WeightWorkoutType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public WeightWorkoutTypeDTO updateWeightWorkoutType(WeightWorkoutTypeDTO data) throws Exception {
		Optional<WeightWorkoutType> weightworkouttypeOptional = service.findById(data.getWeightWorkoutTypeId());
		if(weightworkouttypeOptional.isPresent()) {
		    WeightWorkoutType updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getWeightWorkoutTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a WeightWorkoutType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteWeightWorkoutType(int id) throws Exception {
		Optional<WeightWorkoutType> weightworkouttypeOptional = service.findById(id);
		if(weightworkouttypeOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}
}
