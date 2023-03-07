package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.StepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Steps;
import com.schnarbiesnmeowers.nmsmonolith.repositories.StepsRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class StepsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private StepsRepository stepsRepository;

	/**
	 * get all Steps records
	 * @return
	 * @throws Exception
	 */
	public List<StepsDTO> getAllSteps() throws Exception {
		Iterable<Steps> steps = stepsRepository.findAll();
		Iterator<Steps> stepss = steps.iterator();
		List<StepsDTO> stepsdto = new ArrayList();
		while(stepss.hasNext()) {
			Steps item = stepss.next();
			stepsdto.add(item.toDTO());
		}
		return stepsdto;
	}

	/**
	 * get Steps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public StepsDTO findStepsById(int id) throws Exception {
		Optional<Steps> stepsOptional = stepsRepository.findById(id);
		if(stepsOptional.isPresent()) {
			Steps results = stepsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Steps
	 * @param data
	 * @return
	 */
	public StepsDTO createSteps(StepsDTO data) {
		try {
		    Steps createdData = data.toEntity();
		    createdData = stepsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Steps
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public StepsDTO updateSteps(StepsDTO data) throws Exception {
		Optional<Steps> stepsOptional = stepsRepository.findById(data.getStepId());
		if(stepsOptional.isPresent()) {
		    Steps updatedData = data.toEntity();
			updatedData = stepsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getStepId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Steps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteSteps(int id) throws Exception {
		Optional<Steps> stepsOptional = stepsRepository.findById(id);
		if(stepsOptional.isPresent()) {
			stepsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<StepsDTO> by foreign key : workoutId
	 * @param workoutId
	 * @return List<Steps>
	 * @throws Exception
	*/
	public List<StepsDTO> findStepsByWorkoutId(int id) throws Exception {
		Iterable<Steps> results = stepsRepository.findStepsByWorkoutId(id);
		Iterator<Steps> iter = results.iterator();
		List<StepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Steps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
