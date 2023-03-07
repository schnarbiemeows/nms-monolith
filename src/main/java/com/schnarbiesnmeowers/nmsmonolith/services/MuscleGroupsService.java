package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MuscleGroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.MuscleGroups;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MuscleGroupsRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class MuscleGroupsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private MuscleGroupsRepository muscleGroupsRepository;

	/**
	 * get all MuscleGroups records
	 * @return
	 * @throws Exception
	 */
	public List<MuscleGroupsDTO> getAllMuscleGroups() throws Exception {
		Iterable<MuscleGroups> musclegroups = muscleGroupsRepository.findAll();
		Iterator<MuscleGroups> musclegroupss = musclegroups.iterator();
		List<MuscleGroupsDTO> musclegroupsdto = new ArrayList();
		while(musclegroupss.hasNext()) {
			MuscleGroups item = musclegroupss.next();
			musclegroupsdto.add(item.toDTO());
		}
		return musclegroupsdto;
	}

	/**
	 * get MuscleGroups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MuscleGroupsDTO findMuscleGroupsById(int id) throws Exception {
		Optional<MuscleGroups> musclegroupsOptional = muscleGroupsRepository.findById(id);
		if(musclegroupsOptional.isPresent()) {
			MuscleGroups results = musclegroupsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new MuscleGroups
	 * @param data
	 * @return
	 */
	public MuscleGroupsDTO createMuscleGroups(MuscleGroupsDTO data) {
		try {
		    MuscleGroups createdData = data.toEntity();
		    createdData = muscleGroupsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a MuscleGroups
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public MuscleGroupsDTO updateMuscleGroups(MuscleGroupsDTO data) throws Exception {
		Optional<MuscleGroups> musclegroupsOptional = muscleGroupsRepository.findById(data.getMuscleGroupId());
		if(musclegroupsOptional.isPresent()) {
		    MuscleGroups updatedData = data.toEntity();
			updatedData = muscleGroupsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getMuscleGroupId() + NOT_FOUND);
		}
	}

	/**
	 * delete a MuscleGroups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteMuscleGroups(int id) throws Exception {
		Optional<MuscleGroups> musclegroupsOptional = muscleGroupsRepository.findById(id);
		if(musclegroupsOptional.isPresent()) {
			muscleGroupsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
