package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftSteps;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftStepsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LiftStepsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftStepsRepository liftStepsRepository;

	/**
	 * get all LiftSteps records
	 * @return
	 * @throws Exception
	 */
	public List<LiftStepsDTO> getAllLiftSteps() throws Exception {
		Iterable<LiftSteps> liftsteps = liftStepsRepository.findAll();
		Iterator<LiftSteps> liftstepss = liftsteps.iterator();
		List<LiftStepsDTO> liftstepsdto = new ArrayList();
		while(liftstepss.hasNext()) {
			LiftSteps item = liftstepss.next();
			liftstepsdto.add(item.toDTO());
		}
		return liftstepsdto;
	}

	/**
	 * get LiftSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LiftStepsDTO findLiftStepsById(int id) throws Exception {
		Optional<LiftSteps> liftstepsOptional = liftStepsRepository.findById(id);
		if(liftstepsOptional.isPresent()) {
			LiftSteps results = liftstepsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LiftSteps
	 * @param data
	 * @return
	 */
	public LiftStepsDTO createLiftSteps(LiftStepsDTO data) {
		try {
		    LiftSteps createdData = data.toEntity();
		    createdData = liftStepsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LiftSteps
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LiftStepsDTO updateLiftSteps(LiftStepsDTO data) throws Exception {
		Optional<LiftSteps> liftstepsOptional = liftStepsRepository.findById(data.getLiftStepId());
		if(liftstepsOptional.isPresent()) {
		    LiftSteps updatedData = data.toEntity();
			updatedData = liftStepsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getLiftStepId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LiftSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLiftSteps(int id) throws Exception {
		Optional<LiftSteps> liftstepsOptional = liftStepsRepository.findById(id);
		if(liftstepsOptional.isPresent()) {
			liftStepsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : liftId
	 * @param liftId
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	public List<LiftStepsDTO> findLiftStepsByLiftId(int id) throws Exception {
		Iterable<LiftSteps> results = liftStepsRepository.findLiftStepsByLiftId(id);
		Iterator<LiftSteps> iter = results.iterator();
		List<LiftStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LiftSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	public List<LiftStepsDTO> findLiftStepsByImageLoc(int id) throws Exception {
		Iterable<LiftSteps> results = liftStepsRepository.findLiftStepsByImageLoc(id);
		Iterator<LiftSteps> iter = results.iterator();
		List<LiftStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LiftSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : LiftIdAndImageLoc
	 * @param LiftIdAndImageLoc
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	public List<LiftStepsDTO> findLiftStepsByLiftIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<LiftSteps> results = liftStepsRepository.findLiftStepsByLiftIdAndImageLoc(id0, id1);
		Iterator<LiftSteps> iter = results.iterator();
		List<LiftStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LiftSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
