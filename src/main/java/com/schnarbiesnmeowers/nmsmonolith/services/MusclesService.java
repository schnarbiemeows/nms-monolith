package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MusclesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Muscles;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MusclesRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class MusclesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private MusclesRepository musclesRepository;

	/**
	 * get all Muscles records
	 * @return
	 * @throws Exception
	 */
	public List<MusclesDTO> getAllMuscles() throws Exception {
		Iterable<Muscles> muscles = musclesRepository.findAll();
		Iterator<Muscles> muscless = muscles.iterator();
		List<MusclesDTO> musclesdto = new ArrayList();
		while(muscless.hasNext()) {
			Muscles item = muscless.next();
			musclesdto.add(item.toDTO());
		}
		return musclesdto;
	}

	/**
	 * get Muscles by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MusclesDTO findMusclesById(int id) throws Exception {
		Optional<Muscles> musclesOptional = musclesRepository.findById(id);
		if(musclesOptional.isPresent()) {
			Muscles results = musclesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Muscles
	 * @param data
	 * @return
	 */
	public MusclesDTO createMuscles(MusclesDTO data) {
		try {
		    Muscles createdData = data.toEntity();
		    createdData = musclesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Muscles
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public MusclesDTO updateMuscles(MusclesDTO data) throws Exception {
		Optional<Muscles> musclesOptional = musclesRepository.findById(data.getMuscleId());
		if(musclesOptional.isPresent()) {
		    Muscles updatedData = data.toEntity();
			updatedData = musclesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getMuscleId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Muscles by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteMuscles(int id) throws Exception {
		Optional<Muscles> musclesOptional = musclesRepository.findById(id);
		if(musclesOptional.isPresent()) {
			musclesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<MusclesDTO> by foreign key : muscleGroupId
	 * @param muscleGroupId
	 * @return List<Muscles>
	 * @throws Exception
	*/
	public List<MusclesDTO> findMusclesByMuscleGroupId(int id) throws Exception {
		Iterable<Muscles> results = musclesRepository.findMusclesByMuscleGroupId(id);
		Iterator<Muscles> iter = results.iterator();
		List<MusclesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Muscles item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<MusclesDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<Muscles>
	 * @throws Exception
	*/
	public List<MusclesDTO> findMusclesByImageLoc(int id) throws Exception {
		Iterable<Muscles> results = musclesRepository.findMusclesByImageLoc(id);
		Iterator<Muscles> iter = results.iterator();
		List<MusclesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Muscles item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<MusclesDTO> by foreign key : MuscleGroupIdAndImageLoc
	 * @param MuscleGroupIdAndImageLoc
	 * @return List<Muscles>
	 * @throws Exception
	*/
	public List<MusclesDTO> findMusclesByMuscleGroupIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<Muscles> results = musclesRepository.findMusclesByMuscleGroupIdAndImageLoc(id0, id1);
		Iterator<Muscles> iter = results.iterator();
		List<MusclesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Muscles item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
