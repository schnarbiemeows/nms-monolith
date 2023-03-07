package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LiftsServiceTest {


	/**
	 * get all Lifts records
	 * @return
	 * @throws Exception
	 */
	public List<LiftsDTO> getAllLifts() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<LiftsDTO> liftsDTO = new ArrayList<LiftsDTO>();
		return liftsDTO;
	}

	/**
	 * get Lifts by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LiftsDTO findLiftsById(int id) throws Exception {
		return new LiftsDTO();
	}

	/**
	 * create a new Lifts
	 * @param data
	 * @return
	 */
	public LiftsDTO createLifts(LiftsDTO data) {
        data.setLiftId(1);
        return data;
	}

	/**
	 * update a Lifts
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LiftsDTO updateLifts(LiftsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Lifts by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLifts(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<LiftsDTO> by foreign key : muscleId
	 * @param muscleId
	 * @return List<Lifts>
	 * @throws Exception
	*/
	public List<LiftsDTO> findLiftsByMuscleId(int id) throws Exception {
		List<LiftsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<LiftsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<Lifts>
	 * @throws Exception
	*/
	public List<LiftsDTO> findLiftsByImageLoc(int id) throws Exception {
		List<LiftsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<LiftsDTO> by foreign key : MuscleIdAndImageLoc
	 * @param MuscleIdAndImageLoc
	 * @return List<Lifts>
	 * @throws Exception
	*/
	public List<LiftsDTO> findLiftsByMuscleIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<LiftsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
