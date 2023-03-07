package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MusclesDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class MusclesServiceTest {


	/**
	 * get all Muscles records
	 * @return
	 * @throws Exception
	 */
	public List<MusclesDTO> getAllMuscles() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<MusclesDTO> musclesDTO = new ArrayList<MusclesDTO>();
		return musclesDTO;
	}

	/**
	 * get Muscles by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MusclesDTO findMusclesById(int id) throws Exception {
		return new MusclesDTO();
	}

	/**
	 * create a new Muscles
	 * @param data
	 * @return
	 */
	public MusclesDTO createMuscles(MusclesDTO data) {
        data.setMuscleId(1);
        return data;
	}

	/**
	 * update a Muscles
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public MusclesDTO updateMuscles(MusclesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Muscles by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteMuscles(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<MusclesDTO> by foreign key : muscleGroupId
	 * @param id
	 * @return List<Muscles>
	 * @throws Exception
	*/
	public List<MusclesDTO> findMusclesByMuscleGroupId(int id) throws Exception {
		List<MusclesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<MusclesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<Muscles>
	 * @throws Exception
	*/
	public List<MusclesDTO> findMusclesByImageLoc(int id) throws Exception {
		List<MusclesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<MusclesDTO> by foreign key : MuscleGroupIdAndImageLoc
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<MusclesDTO> findMusclesByMuscleGroupIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<MusclesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
