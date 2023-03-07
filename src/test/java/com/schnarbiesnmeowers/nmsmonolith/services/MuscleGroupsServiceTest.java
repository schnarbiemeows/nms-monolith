package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MuscleGroupsDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class MuscleGroupsServiceTest {


	/**
	 * get all MuscleGroups records
	 * @return
	 * @throws Exception
	 */
	public List<MuscleGroupsDTO> getAllMuscleGroups() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<MuscleGroupsDTO> musclegroupsDTO = new ArrayList<MuscleGroupsDTO>();
		return musclegroupsDTO;
	}

	/**
	 * get MuscleGroups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MuscleGroupsDTO findMuscleGroupsById(int id) throws Exception {
		return new MuscleGroupsDTO();
	}

	/**
	 * create a new MuscleGroups
	 * @param data
	 * @return
	 */
	public MuscleGroupsDTO createMuscleGroups(MuscleGroupsDTO data) {
        data.setMuscleGroupId(1);
        return data;
	}

	/**
	 * update a MuscleGroups
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public MuscleGroupsDTO updateMuscleGroups(MuscleGroupsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a MuscleGroups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteMuscleGroups(int id) throws Exception {
		return "Successfully Deleted";
	}

}
