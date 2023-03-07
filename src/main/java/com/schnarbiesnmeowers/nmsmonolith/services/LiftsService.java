package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Lifts;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LiftsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftsRepository service;

	/**
	 * get all Lifts records
	 * @return
	 * @throws Exception
	 */
	public List<LiftsDTO> getAllLifts() throws Exception {
		Iterable<Lifts> lifts = service.findAll();
		Iterator<Lifts> liftss = lifts.iterator();
		List<LiftsDTO> liftsdto = new ArrayList();
		while(liftss.hasNext()) {
			Lifts item = liftss.next();
			liftsdto.add(item.toDTO());
		}
		return liftsdto;
	}

	/**
	 * get Lifts by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LiftsDTO findLiftsById(int id) throws Exception {
		Optional<Lifts> liftsOptional = service.findById(id);
		if(liftsOptional.isPresent()) {
			Lifts results = liftsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Lifts
	 * @param data
	 * @return
	 */
	public LiftsDTO createLifts(LiftsDTO data) {
		try {
		    Lifts createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Lifts
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LiftsDTO updateLifts(LiftsDTO data) throws Exception {
		Optional<Lifts> liftsOptional = service.findById(data.getLiftId());
		if(liftsOptional.isPresent()) {
		    Lifts updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getLiftId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Lifts by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLifts(int id) throws Exception {
		Optional<Lifts> liftsOptional = service.findById(id);
		if(liftsOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<LiftsDTO> by foreign key : muscleId
	 * @param muscleId
	 * @return List<Lifts>
	 * @throws Exception
	*/
	public List<LiftsDTO> findLiftsByMuscleId(int id) throws Exception {
		Iterable<Lifts> results = service.findLiftsByMuscleId(id);
		Iterator<Lifts> iter = results.iterator();
		List<LiftsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Lifts item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LiftsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<Lifts>
	 * @throws Exception
	*/
	public List<LiftsDTO> findLiftsByImageLoc(int id) throws Exception {
		Iterable<Lifts> results = service.findLiftsByImageLoc(id);
		Iterator<Lifts> iter = results.iterator();
		List<LiftsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Lifts item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LiftsDTO> by foreign key : MuscleIdAndImageLoc
	 * @param MuscleIdAndImageLoc
	 * @return List<Lifts>
	 * @throws Exception
	*/
	public List<LiftsDTO> findLiftsByMuscleIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<Lifts> results = service.findLiftsByMuscleIdAndImageLoc(id0, id1);
		Iterator<Lifts> iter = results.iterator();
		List<LiftsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Lifts item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
