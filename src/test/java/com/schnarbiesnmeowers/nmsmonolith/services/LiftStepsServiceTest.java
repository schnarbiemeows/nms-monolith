package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftStepsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LiftStepsServiceTest {


	/**
	 * get all LiftSteps records
	 * @return
	 * @throws Exception
	 */
	public List<LiftStepsDTO> getAllLiftSteps() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<LiftStepsDTO> liftstepsDTO = new ArrayList<LiftStepsDTO>();
		return liftstepsDTO;
	}

	/**
	 * get LiftSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LiftStepsDTO findLiftStepsById(int id) throws Exception {
		return new LiftStepsDTO();
	}

	/**
	 * create a new LiftSteps
	 * @param data
	 * @return
	 */
	public LiftStepsDTO createLiftSteps(LiftStepsDTO data) {
        data.setLiftStepId(1);
        return data;
	}

	/**
	 * update a LiftSteps
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LiftStepsDTO updateLiftSteps(LiftStepsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a LiftSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLiftSteps(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : liftId
	 * @param liftId
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	public List<LiftStepsDTO> findLiftStepsByLiftId(int id) throws Exception {
		List<LiftStepsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	public List<LiftStepsDTO> findLiftStepsByImageLoc(int id) throws Exception {
		List<LiftStepsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : LiftIdAndImageLoc
	 * @param LiftIdAndImageLoc
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	public List<LiftStepsDTO> findLiftStepsByLiftIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<LiftStepsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
