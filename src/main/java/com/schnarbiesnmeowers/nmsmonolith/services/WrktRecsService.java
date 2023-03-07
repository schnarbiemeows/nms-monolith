package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.WrktRecsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.WrktRecs;
import com.schnarbiesnmeowers.nmsmonolith.repositories.WrktRecsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class WrktRecsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WrktRecsRepository wrktRecsRepository;

	/**
	 * get all WrktRecs records
	 * @return
	 * @throws Exception
	 */
	public List<WrktRecsDTO> getAllWrktRecs() throws Exception {
		Iterable<WrktRecs> wrktrecs = wrktRecsRepository.findAll();
		Iterator<WrktRecs> wrktrecss = wrktrecs.iterator();
		List<WrktRecsDTO> wrktrecsdto = new ArrayList();
		while(wrktrecss.hasNext()) {
			WrktRecs item = wrktrecss.next();
			wrktrecsdto.add(item.toDTO());
		}
		return wrktrecsdto;
	}

	/**
	 * get WrktRecs by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public WrktRecsDTO findWrktRecsById(int id) throws Exception {
		Optional<WrktRecs> wrktrecsOptional = wrktRecsRepository.findById(id);
		if(wrktrecsOptional.isPresent()) {
			WrktRecs results = wrktrecsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new WrktRecs
	 * @param data
	 * @return
	 */
	public WrktRecsDTO createWrktRecs(WrktRecsDTO data) {
		try {
		    WrktRecs createdData = data.toEntity();
		    createdData = wrktRecsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a WrktRecs
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public WrktRecsDTO updateWrktRecs(WrktRecsDTO data) throws Exception {
		Optional<WrktRecs> wrktrecsOptional = wrktRecsRepository.findById(data.getWrktRecId());
		if(wrktrecsOptional.isPresent()) {
		    WrktRecs updatedData = data.toEntity();
			updatedData = wrktRecsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getWrktRecId() + NOT_FOUND);
		}
	}

	/**
	 * delete a WrktRecs by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteWrktRecs(int id) throws Exception {
		Optional<WrktRecs> wrktrecsOptional = wrktRecsRepository.findById(id);
		if(wrktrecsOptional.isPresent()) {
			wrktRecsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : workoutId
	 * @param workoutId
	 * @return List<WrktRecs>
	 * @throws Exception
	*/
	public List<WrktRecsDTO> findWrktRecsByWorkoutId(int id) throws Exception {
		Iterable<WrktRecs> results = wrktRecsRepository.findWrktRecsByWorkoutId(id);
		Iterator<WrktRecs> iter = results.iterator();
		List<WrktRecsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			WrktRecs item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : liftId
	 * @param liftId
	 * @return List<WrktRecs>
	 * @throws Exception
	*/
	public List<WrktRecsDTO> findWrktRecsByLiftId(int id) throws Exception {
		Iterable<WrktRecs> results = wrktRecsRepository.findWrktRecsByLiftId(id);
		Iterator<WrktRecs> iter = results.iterator();
		List<WrktRecsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			WrktRecs item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : WorkoutIdAndLiftId
	 * @param WorkoutIdAndLiftId
	 * @return List<WrktRecs>
	 * @throws Exception
	*/
	public List<WrktRecsDTO> findWrktRecsByWorkoutIdAndLiftId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<WrktRecs> results = wrktRecsRepository.findWrktRecsByWorkoutIdAndLiftId(id0, id1);
		Iterator<WrktRecs> iter = results.iterator();
		List<WrktRecsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			WrktRecs item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
